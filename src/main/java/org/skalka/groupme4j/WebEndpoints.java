package org.skalka.groupme4j;

public class WebEndpoints {

  public static final String BASE_URL = "https://api.groupme.com/v3";

  public static final String GROUPS = BASE_URL + "/groups";

  public static final String GROUPS_FORMER = GROUPS + "/former";

  public static final String GROUPS_SHOW = GROUPS + "/%s";

  public static final String GROUPS_CREATE = GROUPS;

  public static final String GROUPS_UPDATE = GROUPS + "/%s/update";

  public static final String GROUPS_DESTROY = GROUPS + "/%s/destroy";

  public static final String GROUPS_JOIN = GROUPS + "/%s/join/%s";

  public static final String GROUPS_REJOIN = GROUPS + "/join";

  public static final String GROUPS_CHANGE_OWNER = GROUPS + "/change_owners";
  
  
  public static final String MESSAGES = GROUPS + "/%s/messages";
  
  public static final String MESSAGES_CREATE = MESSAGES;
  
  public static final String MESSAGES_LIKE = BASE_URL + "/messages/%s/%s/like";
  
  public static final String MESSAGES_UNLIKE = BASE_URL + "/messages/%s/%s/unlike";
  
  
  public static final String CHATS = BASE_URL + "/chats";
  
  
  public static final String DIRECT_MESSAGES = BASE_URL + "/direct_messages";
  
  
  public static final String LEADERBOARD_INDEX = BASE_URL + "/groups/%s/likes";
  
  public static final String LEADERBOARD_MINE = LEADERBOARD_INDEX + "/mine";
  
  public static final String LEADERBOARD_HITS = LEADERBOARD_INDEX + "/for_me";
  
  
  public static final String BOT = BASE_URL + "/bots";
  
  public static final String BOT_INDEX = BOT;
  
  public static final String BOT_CREATE = BOT;
  
  public static final String BOT_POST = BOT + "/post";
  
  public static final String BOT_DESTROY = BOT + "/destroy";
  
  
  public static final String USER = BASE_URL + "/users";
  
  public static final String USER_ME = USER + "/me";
  
  public static final String USER_UPDATE = USER + "/update";
  
  
  public static final String SMS_MODE = USER + "/sms_mode";
  
  public static final String SMS_MODE_CREATE = SMS_MODE;
  
  public static final String SMS_MODE_DELETE = SMS_MODE + "/delete";
  
  
  public static final String BLOCKS = BASE_URL + "/blocks";
  
  public static final String BLOCKS_BETWEEN = BLOCKS + "/between";
  
}
