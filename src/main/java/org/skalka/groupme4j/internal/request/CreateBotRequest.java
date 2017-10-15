package org.skalka.groupme4j.internal.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class CreateBotRequest {
    
    @Getter @Setter
    @JsonProperty("bot[avatar_url]")
    private String avatarUrl;
    
    @Getter @Setter
    @JsonProperty("bot[callback_url]")
    private String callbackUrl;
    
    @Getter @Setter
    @JsonProperty("bot[dm_notification]")
    private Integer dmNotification;

    @Getter @Setter
    @JsonProperty("bot[group_id]")
    private String groupId;
    
    @Getter @Setter
    @JsonProperty("bot[name]")
    private String name;
    
}
