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
    
    
    public final static String CHATS = BASE_URL + "/chats";
    
    
    public final static String DIRECT_MESSAGES = BASE_URL + "/direct_messages";
    
    
    public final static String USER = BASE_URL + "/users";
    
    public final static String USER_ME = USER + "/me";
    
    public final static String USER_UPDATE = USER + "/update";
    
    
    public final static String SMS_MODE = USER + "/sms_mode";
    
    public final static String SMS_MODE_CREATE = SMS_MODE;
    
    public final static String SMS_MODE_DELETE = SMS_MODE + "/delete";
    
}
