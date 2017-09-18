package org.skalka.groupme4j;

import java.io.IOException;
import java.util.List;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.skalka.groupme4j.converter.ConverterFactory;

import org.skalka.groupme4j.converter.RequestConverter;
import org.skalka.groupme4j.converter.ResponseConverter;
import org.skalka.groupme4j.exception.GroupMeAPIException;
import org.skalka.groupme4j.request.group.CreateGroupRequest;
import org.skalka.groupme4j.request.group.RejoinGroupRequest;
import org.skalka.groupme4j.request.group.UpdateGroupRequest;
import org.skalka.groupme4j.model.group.Group;
import org.skalka.groupme4j.response.RestfulResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GroupMe4J {

    private final static Logger LOGGER = LoggerFactory.getLogger(GroupMe4J.class);
    
    private final OkHttpClient client =  new OkHttpClient();
    private final String token;

    public GroupMe4J(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }

    public List<Group> getGroups(Integer page, Integer per_page) throws GroupMeAPIException {
        RestfulResponse<List<Group>> response = null;

        try {
            LOGGER.debug("Connecting to: '{}'", WebEndpoints.GROUPS);
            HttpUrl url = HttpUrl.parse(WebEndpoints.GROUPS).newBuilder()
                    .query(String.format("token=%s&page=%s&per_page=%s", token, page, per_page))
                    .build();

            Request request = (new Request.Builder()).url(url).build();
            String json = client.newCall(request).execute().body().string();

            ResponseConverter<RestfulResponse<List<Group>>> mec = ConverterFactory.getMERC(Group.class);
            response = mec.parse(json);
        } catch (IOException IOE) {
            LOGGER.error("There was an error retrieving information from GroupMe: {}", IOE.getMessage());
            throw new GroupMeAPIException();
        }

        return response.getResponse();
    }

    public List<Group> getFormerGroups() throws GroupMeAPIException {
        RestfulResponse<List<Group>> response = null;

        try {
            LOGGER.debug("Connecting to: '{}'", WebEndpoints.GROUPS_FORMER);
            HttpUrl url = HttpUrl.parse(WebEndpoints.GROUPS_FORMER).newBuilder()
                    .query(String.format("token=%s", token))
                    .build();

            Request request = (new Request.Builder()).url(url).build();
            String json = client.newCall(request).execute().body().string();

            ResponseConverter<RestfulResponse<List<Group>>> mec = ConverterFactory.getMERC(Group.class);
            response = mec.parse(json);
        } catch (IOException IOE) {
            LOGGER.error("There was an error retrieving information from GroupMe: {}", IOE.getMessage());
            throw new GroupMeAPIException();
        }

        return response.getResponse();
    }

    public Group getGroupById(String id) throws GroupMeAPIException {
        RestfulResponse<Group> response = null;

        try {
            LOGGER.debug("Connecting to: '{}'", WebEndpoints.GROUPS_SHOW);
            HttpUrl url = HttpUrl.parse(String.format(WebEndpoints.GROUPS_SHOW, id))
                    .newBuilder().query(String.format("token=%s", token))
                    .build();

            Request request = (new Request.Builder()).url(url).build();
            String json = client.newCall(request).execute().body().string();

            ResponseConverter<RestfulResponse<Group>> sec = ConverterFactory.getSERC(Group.class);
            response = sec.parse(json);
        } catch (IOException IOE) {
            LOGGER.error("There was an error retrieving information from GroupMe: {}", IOE.getMessage());
            throw new GroupMeAPIException();
        }

        return response.getResponse();
    }

    public Group createGroup(String name) throws GroupMeAPIException {
        return createGroup(name, null, null, false);
    }

    public Group createGroup(String name, String description, String imageUrl, boolean share) throws GroupMeAPIException {
        RestfulResponse<Group> response = null;

        try {
            CreateGroupRequest createRequest = new CreateGroupRequest();
            createRequest.setName(name);
            createRequest.setDescription(description);
            createRequest.setImageUrl(imageUrl);
            createRequest.setShared(share);

            RequestConverter<CreateGroupRequest> rc = new RequestConverter<CreateGroupRequest>();
            String requestJson = rc.parseObjectRequest(createRequest);

            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), requestJson);
            HttpUrl url = HttpUrl.parse(String.format(WebEndpoints.GROUPS_CREATE))
                    .newBuilder().build();

            Request request = new Request.Builder()
                    .url(url).addHeader("X-Access-Token", token)
                    .post(body).build();

            String responseJson = client.newCall(request).execute().body().string();
            ResponseConverter<RestfulResponse<Group>> sec = ConverterFactory.getSERC(Group.class);
            response = sec.parse(responseJson);
        } catch (IOException | GroupMeAPIException E) {
            LOGGER.error("There was an error retrieving information from GroupMe: {}", E.getMessage());
            throw new GroupMeAPIException();
        }

        return response.getResponse();
    }

    public Group updateGroup(String id, String name) throws GroupMeAPIException {
        Group g = getGroupById(id);
        return updateGroup(id, name, g.getImageUrl(), !g.getShareUrl().isEmpty(), g.isOfficeMode());
    }

    public Group updateGroup(String id, String name, String imageUrl, boolean shared, boolean officeMode) throws GroupMeAPIException {
        RestfulResponse<Group> response = null;

        try {
            UpdateGroupRequest createRequest = new UpdateGroupRequest();
            createRequest.setName(name);
            createRequest.setImageUrl(imageUrl);
            createRequest.setShared(shared);
            createRequest.setOfficeMode(officeMode);

            RequestConverter<UpdateGroupRequest> rc = new RequestConverter<UpdateGroupRequest>();
            String requestJson = rc.parseObjectRequest(createRequest);

            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), requestJson);
            HttpUrl url = HttpUrl.parse(String.format(WebEndpoints.GROUPS_UPDATE, id))
                    .newBuilder().build();

            Request request = new Request.Builder()
                    .url(url).addHeader("X-Access-Token", token)
                    .post(body).build();

            String responseJson = client.newCall(request).execute().body().string();
            ResponseConverter<RestfulResponse<Group>> sec = ConverterFactory.getSERC(Group.class);
            response = sec.parse(responseJson);
        } catch (IOException IOE) {
            LOGGER.error("There was an error retrieving information from GroupMe: {}", IOE.getMessage());
            throw new GroupMeAPIException();
        }

        return response.getResponse();
    }

    public boolean destoryGroup(String id) throws GroupMeAPIException {
        Integer responseCode = null;

        try {
            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), "");
            HttpUrl url = HttpUrl.parse(String.format(WebEndpoints.GROUPS_DESTROY, id))
                    .newBuilder().build();

            Request request = new Request.Builder()
                    .url(url).addHeader("X-Access-Token", token)
                    .post(body).build();

            responseCode = client.newCall(request).execute().code();
        } catch (IOException IOE) {
            LOGGER.error("There was an error retrieving information from GroupMe: {}", IOE.getMessage());
            throw new GroupMeAPIException();
        }

        return (responseCode.intValue() == 200);
    }

    public Group joinGroup(String id, String shareToken) throws GroupMeAPIException {
        RestfulResponse<Group> response = null;

        try {
            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), "");
            HttpUrl url = HttpUrl.parse(String.format(WebEndpoints.GROUPS_JOIN, id, shareToken))
                    .newBuilder().build();

            Request request = new Request.Builder()
                    .url(url).addHeader("X-Access-Token", token)
                    .post(body).build();

            String responseJson = client.newCall(request).execute().body().string();
            ResponseConverter<RestfulResponse<Group>> sec = ConverterFactory.getSERC(Group.class);
            response = sec.parse(responseJson);
        } catch (IOException IOE) {
            LOGGER.error("There was an error retrieving information from GroupMe: {}", IOE.getMessage());
            throw new GroupMeAPIException();
        }

        return response.getResponse();
    }

    public Group rejoinGroup(String id) throws GroupMeAPIException {
        RestfulResponse<Group> response = null;

        try {
            RejoinGroupRequest rejoinRequest = new RejoinGroupRequest();
            rejoinRequest.setGroupId(id);

            RequestConverter<RejoinGroupRequest> rc = new RequestConverter<RejoinGroupRequest>();
            String requestJson = rc.parseObjectRequest(rejoinRequest);

            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), requestJson);
            HttpUrl url = HttpUrl.parse(String.format(WebEndpoints.GROUPS_REJOIN))
                    .newBuilder().build();

            Request request = new Request.Builder()
                    .url(url).addHeader("X-Access-Token", token)
                    .post(body).build();

            String responseJson = client.newCall(request).execute().body().string();
            ResponseConverter<RestfulResponse<Group>> sec = ConverterFactory.getSERC(Group.class);
            response = sec.parse(responseJson);
        } catch (IOException IOE) {
            LOGGER.error("There was an error retrieving information from GroupMe: {}", IOE.getMessage());
            throw new GroupMeAPIException();
        }

        return response.getResponse();
    }
}
