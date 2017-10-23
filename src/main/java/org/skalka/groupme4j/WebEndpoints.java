package org.skalka.groupme4j;

public class WebEndpoints {

    public final static String BASE_URL = "https://api.groupme.com/v3";

    public final static String GROUPS = BASE_URL + "/groups";

    public final static String GROUPS_FORMER = GROUPS + "/former";

    public final static String GROUPS_SHOW = GROUPS + "/%s";

    public final static String GROUPS_CREATE = GROUPS;

    public final static String GROUPS_UPDATE = GROUPS + "/%s/update";

    public final static String GROUPS_DESTROY = GROUPS + "/%s/destroy";

    public final static String GROUPS_JOIN = GROUPS + "/%s/join/%s";

    public final static String GROUPS_REJOIN = GROUPS + "/join";

    public final static String GROUPS_CHANGE_OWNER = GROUPS + "/change_owners";
    
    
    public final static String MESSAGES = GROUPS + "/%s/messages";
    
    public final static String MESSAGES_CREATE = MESSAGES;
    
    public final static String MESSAGES_LIKE = BASE_URL + "/messages/%s/%s/like";
    
    public final static String MESSAGES_UNLIKE = BASE_URL + "/messages/%s/%s/unlike";
    
    
    public final static String CHATS = BASE_URL + "/chats";
    
    
    public final static String DIRECT_MESSAGES = BASE_URL + "/direct_messages";
    
    
    public final static String LEADERBOARD_INDEX = BASE_URL + "/groups/%s/likes";
    
    public final static String LEADERBOARD_MINE = LEADERBOARD_INDEX + "/mine";
    
    public final static String LEADERBOARD_HITS = LEADERBOARD_INDEX + "/for_me";
    
    public final static String BOT = BASE_URL + "/bots";
    
    public final static String BOT_INDEX = BOT;
    
    public final static String BOT_CREATE = BOT;
    
    public final static String BOT_POST = BOT + "/post";
    
    public final static String BOT_DESTROY = BOT + "/destroy";
    
    
    public final static String USER = BASE_URL + "/users";
    
    public final static String USER_ME = USER + "/me";
    
    public final static String USER_UPDATE = USER + "/update";
    
    
    public final static String SMS_MODE = USER + "/sms_mode";
    
    public final static String SMS_MODE_CREATE = SMS_MODE;
    
    public final static String SMS_MODE_DELETE = SMS_MODE + "/delete";
    
    
    public final static String BLOCKS = BASE_URL + "/blocks";
    
    public final static String BLOCKS_BETWEEN = BLOCKS + "/between";
    
}
