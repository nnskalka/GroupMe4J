package org.skalka.groupme4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.skalka.groupme4j.exception.GroupMeException;
import org.skalka.groupme4j.internal.converter.RequestConverter;
import org.skalka.groupme4j.internal.converter.ResponseConverter;
import org.skalka.groupme4j.internal.request.CreateBotMessageRequest;
import org.skalka.groupme4j.internal.request.CreateBotRequest;
import org.skalka.groupme4j.internal.request.CreateDirectMessageRequest;
import org.skalka.groupme4j.internal.request.CreateGroupMessageRequest;
import org.skalka.groupme4j.internal.request.CreateGroupRequest;
import org.skalka.groupme4j.internal.request.CreateSmsModeRequest;
import org.skalka.groupme4j.internal.request.DestroyBotRequest;
import org.skalka.groupme4j.internal.request.RejoinGroupRequest;
import org.skalka.groupme4j.internal.request.UpdateGroupRequest;
import org.skalka.groupme4j.internal.request.UpdateUserRequest;
import org.skalka.groupme4j.internal.requestor.HttpRequestor;
import org.skalka.groupme4j.internal.requestor.HttpRequestorFactory;
import org.skalka.groupme4j.internal.response.CreateBotResponse;
import org.skalka.groupme4j.internal.response.CreateDirectMessageResponse;
import org.skalka.groupme4j.internal.response.CreateGroupMessageResponse;
import org.skalka.groupme4j.internal.response.GroupMeResponse;
import org.skalka.groupme4j.model.block.Block;
import org.skalka.groupme4j.model.block.BlockBetween;
import org.skalka.groupme4j.model.block.Blocks;
import org.skalka.groupme4j.model.bot.Bot;
import org.skalka.groupme4j.model.chat.Chat;
import org.skalka.groupme4j.model.group.Group;
import org.skalka.groupme4j.model.message.DirectMessage;
import org.skalka.groupme4j.model.message.DirectMessages;
import org.skalka.groupme4j.model.message.GroupMessage;
import org.skalka.groupme4j.model.message.GroupMessages;
import org.skalka.groupme4j.model.message.attachment.Attachment;
import org.skalka.groupme4j.model.user.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GroupMe4JClient {

  private static final Logger LOGGER = LoggerFactory.getLogger(GroupMe4JClient.class);
  private final String token;

  public GroupMe4JClient(String token) {
    this.token = token;
  }

  public String getToken() {
    return this.token;
  }

  // GROUPS
  public List<Group> getGroups() throws GroupMeException {
    return getGroups(null, null);
  }

  public List<Group> getGroups(Integer page, Integer perPage) throws GroupMeException {
    Map<String, Object> queries = new HashMap<>();
    queries.put("token", token);
    queries.put("page", (page != null) ? page : 1);
    queries.put("per_page", (perPage != null) ? perPage : 10);

    return Arrays.asList(get(Group[].class, WebEndpoints.GROUPS, queries));
  }

  public List<Group> getFormerGroups() throws GroupMeException {
    Map<String, Object> queries = new HashMap<>();
    queries.put("token", token);

    return Arrays.asList(get(Group[].class, WebEndpoints.GROUPS_FORMER, queries));
  }

  public Group getGroupById(String id) throws GroupMeException {
    Map<String, Object> queries = new HashMap<>();
    queries.put("token", token);

    return get(Group.class, String.format(WebEndpoints.GROUPS_SHOW, id), queries);
  }

  public Group createGroup(String name) throws GroupMeException {
    return createGroup(name, null, null, false);
  }

  public Group createGroup(String name, String description, String imageUrl, boolean share) throws GroupMeException {
    CreateGroupRequest createRequest = new CreateGroupRequest();
    createRequest.setName(name);
    createRequest.setDescription(description);
    createRequest.setImageUrl(imageUrl);
    createRequest.setShared(share);

    return createGroup(createRequest);
  }

  private Group createGroup(CreateGroupRequest request) throws GroupMeException {
    return post(Group.class, WebEndpoints.GROUPS_CREATE, request);
  }

  public Group updateGroup(String id, String name) throws GroupMeException {
    Group g = getGroupById(id);
    return updateGroup(id, name, g.getImageUrl(), !g.getShareUrl().isEmpty(), g.getOfficeMode());
  }

  public Group updateGroup(String id, String name, String imageUrl, boolean shared, boolean officeMode) throws GroupMeException {
    UpdateGroupRequest createRequest = new UpdateGroupRequest();
    createRequest.setName(name);
    createRequest.setImageUrl(imageUrl);
    createRequest.setShared(shared);
    createRequest.setOfficeMode(officeMode);

    return updateGroup(id, createRequest);
  }

  private Group updateGroup(String id, UpdateGroupRequest createRequest) throws GroupMeException {
    return post(Group.class, String.format(WebEndpoints.GROUPS_UPDATE, id), createRequest);
  }

  public boolean destoryGroup(String id) {
    return post(String.format(WebEndpoints.GROUPS_DESTROY, id), "").isEmpty();
  }

  public Group joinGroup(String id, String shareToken) throws GroupMeException {
    return post(Group.class, String.format(WebEndpoints.GROUPS_JOIN, id, shareToken), "");
  }

  public Group rejoinGroup(String id) throws GroupMeException {
    RejoinGroupRequest rejoinRequest = new RejoinGroupRequest();
    rejoinRequest.setGroupId(id);

    return rejoinGroup(rejoinRequest);
  }

  private Group rejoinGroup(RejoinGroupRequest rejoinRequest) throws GroupMeException {
    return post(Group.class, WebEndpoints.GROUPS_REJOIN, rejoinRequest);
  }

  // MEMBERS
  // MESSAGES
  public GroupMessages getMessagesForGroup(String id) throws GroupMeException {
    return getMessagesForGroup(id, null);
  }

  public GroupMessages getMessagesForGroup(String id, Integer limit) throws GroupMeException {
    return getMessagesForGroup(id, limit, null, null, null);
  }

  public GroupMessages getMessagesForGroup(String id, Integer limit, String beforeId, String sinceId, String afterId) throws GroupMeException {
    Map<String, Object> queries = new HashMap<>();
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

  public GroupMessage postMessage(String id, String text) throws GroupMeException {
    return postMessage(id, text, null);
  }

  public GroupMessage postMessage(String id, List<Attachment> attachments) throws GroupMeException {
    return postMessage(id, null, attachments);
  }

  public GroupMessage postMessage(String id, String text, List<Attachment> attachments) throws GroupMeException {
    CreateGroupMessageRequest cmr = new CreateGroupMessageRequest() {
      {
        setMessage(new MessageRequest() {
          {
            setText(text);

            if (attachments != null) {
              setAttachments(attachments);
            }
          }
        });
      }
    };

    return postMessage(id, cmr);
  }

  private GroupMessage postMessage(String id, CreateGroupMessageRequest cmr) throws GroupMeException {
    return post(CreateGroupMessageResponse.class, String.format(WebEndpoints.MESSAGES_CREATE, id), cmr).getMessage();
  }

  // CHATS
  public List<Chat> getChats() throws GroupMeException {
    return getChats(null, null);
  }

  public List<Chat> getChats(Integer page, Integer perPage) throws GroupMeException {    
    Map<String, Object> queries = new HashMap<>();
    queries.put("token", token);
    queries.put("page", (page != null) ? page : 1);
    queries.put("per_page", (perPage != null) ? perPage : 10);

    return Arrays.asList(get(Chat[].class, WebEndpoints.CHATS, queries));
  }

  // DIRECT MESSAGES
  public DirectMessages getDirectMessages(String otherUserId) throws GroupMeException {
    return getDirectMessages(otherUserId, null, null);
  }

  public DirectMessages getDirectMessages(String otherUserId, String beforeId, String afterId) throws GroupMeException {
    Map<String, Object> queries = new HashMap<>();
    queries.put("token", token);
    queries.put("other_user_id", otherUserId);

    if (beforeId != null) {
      queries.put("before_id", beforeId);
    }

    if (afterId != null) {
      queries.put("after_id", afterId);
    }

    return get(DirectMessages.class, WebEndpoints.DIRECT_MESSAGES, queries);
  }

  public DirectMessage postDirectMessage(String conversationId, String text) throws GroupMeException {
    return postDirectMessage(conversationId, text, null);
  }

  public DirectMessage postDirectMessage(String conversationId, List<Attachment> attachments) throws GroupMeException {
    return postDirectMessage(conversationId, null, attachments);
  }

  public DirectMessage postDirectMessage(String conversationId, String text, List<Attachment> attachments) throws GroupMeException {
    CreateDirectMessageRequest cdmr = new CreateDirectMessageRequest() {
      {
        setDirectMessage(new CreateDirectMessageRequest.MessageRequest() {
          {
            setAttachments(attachments);
            setRecipientId(conversationId);
            setText(text);
          }
        });
      }
    };

    return postDirectMessage(cdmr);
  }

  private DirectMessage postDirectMessage(CreateDirectMessageRequest request) throws GroupMeException {
    return post(CreateDirectMessageResponse.class, WebEndpoints.DIRECT_MESSAGES, request).getMessage();
  }

  // LIKES
  public boolean likeMessage(String groupId, String messageId) {
    return post(String.format(WebEndpoints.MESSAGES_LIKE, groupId, messageId), "").contains("200");
  }
  
  public boolean unlikeMessage(String groupId, String messageId) {
    return post(String.format(WebEndpoints.MESSAGES_UNLIKE, groupId, messageId), "").isEmpty();
  }
  
  // LEADERBOARD
  public List<GroupMessage> getGroupLikes(String groupId, String timePeriod) throws GroupMeException {
    Map<String, Object> queries = new HashMap<>();
    queries.put("period", timePeriod);
    queries.put("token", token);
    
    return get(GroupMessages.class, String.format(WebEndpoints.LEADERBOARD_INDEX, groupId), queries).getMessages();
  }
  
  public List<GroupMessage> getMyGroupLikes(String groupId) throws GroupMeException {
    Map<String, Object> queries = new HashMap<>();
    queries.put("token", token);
    
    return get(GroupMessages.class, String.format(WebEndpoints.LEADERBOARD_MINE, groupId), queries).getMessages();
  }
  
  public List<GroupMessage> getMyGroupHits(String groupId) throws GroupMeException {
    Map<String, Object> queries = new HashMap<>();
    queries.put("token", token);
    
    return get(GroupMessages.class, String.format(WebEndpoints.LEADERBOARD_HITS, groupId), queries).getMessages();
  }
  
  // BOTS
  public Bot createBot(String name, String groupId) throws GroupMeException {
    return createBot(name, groupId, "", "", false);
  }
  
  public Bot createBot(String name, String groupId, String avatarUrl, String callbackUrl, Boolean dmNotification) throws GroupMeException {
    CreateBotRequest request = new CreateBotRequest() {{
        setBot(new NewBot() {{
            setAvatarUrl(avatarUrl);
            setCallbackUrl(callbackUrl);
            setDmNotification(dmNotification);
            setGroupId(groupId);
            setName(name);
          }
        });
      }
    };
    
    return createBot(request);
  }
  
  private Bot createBot(CreateBotRequest request) throws GroupMeException {
    return post(CreateBotResponse.class, WebEndpoints.BOT_CREATE, request).getBot();
  }
  
  public boolean postBotMessage(String botId, String text) {
    CreateBotMessageRequest request = new CreateBotMessageRequest() {{
        setBotId(botId);
        setText(text);
      }
    };
    
    return postBotMessage(request);
  }
  
  public boolean postBotMessage(String botId, String text, List<Attachment> attachments) {
    CreateBotMessageRequest request = new CreateBotMessageRequest() {{
        setAttachments(attachments);
        setBotId(botId);
        setText(text);
      }
    };
    
    return postBotMessage(request);
  }
  
  private boolean postBotMessage(CreateBotMessageRequest request) {
    RequestConverter<CreateBotMessageRequest> converter = new RequestConverter<>();
    String json = converter.parseObjectRequest(request);
    
    return post(WebEndpoints.BOT_POST, json).isEmpty();
  }
  
  public List<Bot> getBots() throws GroupMeException {
    Map<String, Object> queries = new HashMap<>();
    queries.put("token", token);
    
    return Arrays.asList(get(Bot[].class, WebEndpoints.BOT_INDEX, queries));
  }
  
  public boolean deleteBot(String botId) {
    DestroyBotRequest request = new DestroyBotRequest();
    request.setBotId(botId);
    
    return deleteBot(request);
  }
  
  public boolean deleteBot(DestroyBotRequest request) {
    RequestConverter<DestroyBotRequest> converter = new RequestConverter<>();
    String json = converter.parseObjectRequest(request);
    
    return post(WebEndpoints.BOT_DESTROY, json).isEmpty();
  }
  
  // USERS
  public User getMe() throws GroupMeException {
    Map<String, Object> queries = new HashMap<>();
    queries.put("token", token);

    return get(User.class, WebEndpoints.USER_ME, queries);
  }

  public User updateUser(String name) throws GroupMeException {
    return updateUser(name, null, null, null);
  }

  public User updateUser(String name, String avatarUrl, String email, String zipCode) throws GroupMeException {
    UpdateUserRequest request = new UpdateUserRequest();
    User me = getMe();

    request.setAvatarUrl((avatarUrl != null) ? avatarUrl : me.getImageUrl());
    request.setEmail((email != null) ? email : me.getEmail());
    request.setName((name != null) ? name : me.getName());
    request.setZipCode((zipCode != null) ? zipCode : me.getZipCode());

    return updateUser(request);
  }

  private User updateUser(UpdateUserRequest request) throws GroupMeException {
    return post(User.class, WebEndpoints.USER_UPDATE, request);
  }

  // SMS MODE
  public boolean enableSmsMode(Integer duration) {
    CreateSmsModeRequest request = new CreateSmsModeRequest();
    request.setDuration(duration);
    request.setRegistrationId(token);

    RequestConverter<CreateSmsModeRequest> converter = new RequestConverter<>();
    String json = converter.parseObjectRequest(request);

    return post(WebEndpoints.SMS_MODE_CREATE, json).isEmpty();
  }

  public boolean disableSmsMode() {
    return post(WebEndpoints.SMS_MODE_DELETE, "").isEmpty();
  }

  // BLOCKS
  public List<Block> getBlocks() throws GroupMeException {
    User me = getMe();
    
    Map<String, Object> queries = new HashMap<>();
    queries.put("user", me.getId());
    queries.put("token", token);
    
    return get(Blocks.class, WebEndpoints.BLOCKS, queries).getBlocks();
  }
  
  public BlockBetween getBlockBetween(String otherId) throws GroupMeException {
    User me = getMe();
    
    Map<String, Object> queries = new HashMap<>();
    queries.put("user", me.getId());
    queries.put("otherUser", otherId);
    queries.put("token", token);
    
    return get(BlockBetween.class, WebEndpoints.BLOCKS_BETWEEN, queries);
  }
  
  // Utility Methods for GroupMeClient
  private <R> R get(Class<R> returnType, String url, Map<String, Object> queries) throws GroupMeException {
    HttpRequestor requestor = HttpRequestorFactory.getDefaultRequestor();
    LOGGER.debug("Connecting to url (GET): {}", url);
    String respJson = requestor.get(url, queries);

    ResponseConverter<R> responseConverter = new ResponseConverter<>(returnType);
    GroupMeResponse<R> response = responseConverter.parse(respJson.trim());

    if (response.getErrors() != null) {
      throw new GroupMeException(response.getErrors());
    } else if (response.getMetadata().getErrors() != null) {
      throw new GroupMeException(response.getMetadata().getErrors());
    }

    return response.getResponse();
  }

  private <R, Q> R post(Class<R> returnType, String url, Q body) throws GroupMeException {
    RequestConverter<Q> rc = new RequestConverter<>();
    String reqJson = rc.parseObjectRequest(body);

    String respJson = post(url, reqJson.trim());
    ResponseConverter<R> responseConverter = new ResponseConverter<>(returnType);
    GroupMeResponse<R> response = responseConverter.parse(respJson.trim());

    if (response.getErrors() != null) {
      throw new GroupMeException(response.getErrors());
    } else if (response.getMetadata().getErrors() != null) {
      throw new GroupMeException(response.getMetadata().getErrors());
    }

    return response.getResponse();
  }

  private String post(String url, String body) {
    Map<String, Object> headers = new HashMap<>();
    headers.put("X-Access-Token", token);

    HttpRequestor requestor = HttpRequestorFactory.getDefaultRequestor();
    LOGGER.debug("Connecting to url (POST): {}", url);
    String responseJson = requestor.post(url, headers, body);

    return responseJson.trim();
  }

}
