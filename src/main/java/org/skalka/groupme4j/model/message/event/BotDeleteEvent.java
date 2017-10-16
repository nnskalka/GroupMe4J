package org.skalka.groupme4j.model.message.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.skalka.groupme4j.model.JacksonObject;
import org.skalka.groupme4j.model.user.EventUser;

public class BotDeleteEvent extends Event {

    @Getter @Setter
    @JsonProperty("data")
    private BotDeleteEventData data;
    
    public class BotDeleteEventData extends JacksonObject {

        @Getter @Setter
        @JsonProperty("bot")
        private String bot;
        
        @Getter @Setter
        @JsonProperty("user")
        private EventUser user;
        
    }

}
