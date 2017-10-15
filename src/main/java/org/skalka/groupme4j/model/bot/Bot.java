package org.skalka.groupme4j.model.bot;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.skalka.groupme4j.model.JacksonObject;

public class Bot extends JacksonObject {
    
    @Getter @Setter
    @JsonProperty("avatar_url")
    private String avatarUrl;
    
    @Getter @Setter
    @JsonProperty("bot_id")
    private String botId;
    
    @Getter @Setter
    @JsonProperty("callback_url")
    private String callbackUrl;
    
    @Getter @Setter
    @JsonProperty("dm_notification")
    private Boolean dmNotification;
    
    @Getter @Setter
    @JsonProperty("group_id")
    private String groupId;
    
    @Getter @Setter
    @JsonProperty("group_name")
    private String groupName;
    
    @Getter @Setter
    @JsonProperty("name")
    private String name;
    
}
