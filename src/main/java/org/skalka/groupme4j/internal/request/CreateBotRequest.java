package org.skalka.groupme4j.internal.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class CreateBotRequest {
    
    @Getter @Setter
    @JsonProperty("bot")
    private NewBot bot;
    
    public class NewBot {
    
        @Getter @Setter
        @JsonProperty("avatar_url")
        private String avatarUrl;

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
        @JsonProperty("name")
        private String name;
    
    }
}