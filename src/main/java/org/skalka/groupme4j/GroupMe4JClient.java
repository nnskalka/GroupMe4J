package org.skalka.groupme4j;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.skalka.groupme4j.internal.converter.RequestConverter;
import org.skalka.groupme4j.internal.converter.ResponseConverter;
import org.skalka.groupme4j.exception.GroupMeAPIException;
import org.skalka.groupme4j.model.request.CreateGroupRequest;
import org.skalka.groupme4j.model.request.RejoinGroupRequest;
import org.skalka.groupme4j.model.request.UpdateGroupRequest;
import org.skalka.groupme4j.model.group.Group;
import org.skalka.groupme4j.model.message.GroupMessage;
import org.skalka.groupme4j.model.message.GroupMessages;
import org.skalka.groupme4j.model.message.attachment.Attachment;
import org.skalka.groupme4j.internal.requestor.HttpRequestor;
import org.skalka.groupme4j.internal.requestor.HttpRequestorFactory;
import org.skalka.groupme4j.model.chat.Chat;
import org.skalka.groupme4j.model.request.CreateGroupMessageRequest;
import org.skalka.groupme4j.model.response.CreateMessageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GroupMe4JClient {

    private final static Logger LOGGER = LoggerFactory.getLogger(GroupMe4JClient.class);

    private final String token;

    public GroupMe4JClient(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }

    // GROUPS
    public List<Group> getGroups() {
        return getGroups(null, null);
    }

    public List<Group> getGroups(Integer page, Integer per_page) {
        Map<String, Object> queries = new HashMap<String, Object>();
        queries.put("token", token);
        queries.put("page", (page != null) ? page : 1);
        queries.put("per_page", (per_page != null) ? per_page : 10);

        return Arrays.asList(get(Group[].class, WebEndpoints.GROUPS, queries));
    }

    public List<Group> getFormerGroups() {
        Map<String, Object> queries = new HashMap<String, Object>();
        queries.put("token", token);

        return Arrays.asList(get(Group[].class, WebEndpoints.GROUPS_FORMER, queries));
    }

    public Group getGroupById(String id) {
        Map<String, Object> queries = new HashMap<String, Object>();
        queries.put("token", token);

        return get(Group.class, String.format(WebEndpoints.GROUPS_SHOW, id), queries);
    }

    public Group createGroup(String name) {
        return createGroup(name, null, null, false);
    }

    public Group createGroup(String name, String description, String imageUrl, boolean share) {
        CreateGroupRequest createRequest = new CreateGroupRequest();
        createRequest.setName(name);
        createRequest.setDescription(description);
        createRequest.setImageUrl(imageUrl);
        createRequest.setShared(share);

        return post(Group.class, WebEndpoints.GROUPS_CREATE, createRequest);
    }

    public Group updateGroup(String id, String name) {
        Group g = getGroupById(id);
        return updateGroup(id, name, g.getImageUrl(), !g.getShareUrl().isEmpty(), g.getOfficeMode());
    }

    public Group updateGroup(String id, String name, String imageUrl, boolean shared, boolean officeMode) {
        UpdateGroupRequest createRequest = new UpdateGroupRequest();
        createRequest.setName(name);
        createRequest.setImageUrl(imageUrl);
        createRequest.setShared(shared);
        createRequest.setOfficeMode(officeMode);

        return updateGroup(id, createRequest);
    }

    public Group updateGroup(String id, UpdateGroupRequest createRequest) {
        return post(Group.class, String.format(WebEndpoints.GROUPS_UPDATE, id), createRequest);
    }

    public boolean destoryGroup(String id) {
        Integer responseCode = null;

        try {
            // A unique protocol must be implemented in order to check for success
            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), "");
            HttpUrl url = HttpUrl.parse(String.format(WebEndpoints.GROUPS_DESTROY, id))
                    .newBuilder().build();

            Request request = new Request.Builder()
                    .url(url).addHeader("X-Access-Token", token)
                    .post(body).build();

            OkHttpClient client = new OkHttpClient();
            responseCode = client.newCall(request).execute().code();
        } catch (IOException IOE) {
            LOGGER.error("There was an error retrieving information from GroupMe: {}", IOE.getMessage());
            throw new GroupMeAPIException();
        }

        return (responseCode.intValue() == 200);
    }

    public Group joinGroup(String id, String shareToken) {
        return post(Group.class, String.format(WebEndpoints.GROUPS_JOIN, id, shareToken), "");
    }

    public Group rejoinGroup(String id) {
        RejoinGroupRequest rejoinRequest = new RejoinGroupRequest();
        rejoinRequest.setGroupId(id);

        return rejoinGroup(rejoinRequest);
    }

    public Group rejoinGroup(RejoinGroupRequest rejoinRequest) {
        return post(Group.class, WebEndpoints.GROUPS_REJOIN, rejoinRequest);
    }

    // MEMBERS
    // MESSAGES
    public GroupMessages getMessagesForGroup(String id) {
        return getMessagesForGroup(id, null);
    }
    
    public GroupMessages getMessagesForGroup(String id, Integer limit) {
        return getMessagesForGroup(id, limit, null, null, null);
    }

    public GroupMessages getMessagesForGroup(String id, Integer limit, String beforeId, String sinceId, String afterId) {
        Map<String, Object> queries = new HashMap<String, Object>();
        queries.put("limit", (limit != null) ? Math.min(limit, 100) : 20);
        queries.put("token", token);

        if (beforeId != null) {
            queries.put("before_id", beforeId);
        }

        if (sinceId != null) {
            queries.put("since_id", sinceId);
        }

        if (afterId != null) {
            queries.put("after_id", afterId);
        }

        return get(GroupMessages.class, String.format(WebEndpoints.MESSAGES, id), queries);
    }

    public GroupMessage postMessage(String id, String text) {
        return postMessage(id, text, null);
    }

    public GroupMessage postMessage(String id, String text, List<Attachment> attachments) {
        CreateGroupMessageRequest cmr = new CreateGroupMessageRequest() {{
            setMessage(new MessageRequest() {{
                setText(text);

                if (attachments != null) {
                    setAttachments(attachments);
                }
            }});
        }};

        return postMessage(id, cmr);
    }

    public GroupMessage postMessage(String id, CreateGroupMessageRequest cmr) {
        return post(CreateMessageResponse.class, String.format(WebEndpoints.MESSAGES_CREATE, id), cmr).getMessage();
    }

    // CHATS
    public List<Chat> getChats(Integer page, Integer per_page) {
        Map<String, Object> queries = new HashMap<String, Object>();
        queries.put("token", token);
        queries.put("page", (page != null) ? page : 1);
        queries.put("per_page", (per_page != null) ? per_page : 10);

        return Arrays.asList(get(Chat[].class, WebEndpoints.CHATS, queries));
    }
    
    // DIRECT MESSAGES
    // LIKES
    // LEADERBOARD
    // BOTS
    // USERS
    // SMS MODE
    // BLOCKS
    
    // Utility Methods for GroupmeClient
    
    private <RESPONSE> RESPONSE get(Class<RESPONSE> returnType, String url, Map<String, Object> queries) {
        HttpRequestor requestor = HttpRequestorFactory.getDefaultRequestor();
        LOGGER.debug("Connecting to url (GET): {}", url);
        String json = requestor.get(url, queries);

        ResponseConverter<RESPONSE> converter = new ResponseConverter<RESPONSE>(returnType);
        return converter.parse(json.trim()).getResponse();
    }

    private <RESPONSE, REQUEST> RESPONSE post(Class<RESPONSE> response, String url, REQUEST body) {
        RequestConverter<REQUEST> rc = new RequestConverter<REQUEST>();
        String requestJson = rc.parseObjectRequest(body);
        Map<String, Object> headers = new HashMap<String, Object>();
        headers.put("X-Access-Token", token);

        HttpRequestor requestor = HttpRequestorFactory.getDefaultRequestor();
        LOGGER.debug("Connecting to url (POST): {}", url);
        String responseJson = requestor.post(url, headers, requestJson.trim());
        ResponseConverter<RESPONSE> sec = new ResponseConverter<RESPONSE>(response);
        return sec.parse(responseJson.trim()).getResponse();
    }

}
