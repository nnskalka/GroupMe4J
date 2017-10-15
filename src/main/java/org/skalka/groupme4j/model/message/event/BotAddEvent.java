package org.skalka.groupme4j.model.message.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.skalka.groupme4j.model.JacksonObject;

public class BotAddEvent extends Event {
    
    @Getter @Setter
    @JsonProperty("data")
    private BotAddEventData data;
    
    class BotAddEventData extends JacksonObject {

    }
    
}
