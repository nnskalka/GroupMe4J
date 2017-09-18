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
}