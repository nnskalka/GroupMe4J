package org.skalka.groupme4j.model.message.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.skalka.groupme4j.model.JacksonObject;
import org.skalka.groupme4j.model.user.EventUser;

public class CalendarUserUndecidedEvent extends Event {

    @Getter @Setter
    @JsonProperty("data")
    private CalendarUserUndecidedEventData data;
    
    public class CalendarUserUndecidedEventData extends JacksonObject {
        
        @Getter @Setter
        @JsonProperty("event")
        private CalendarEvent event;

        @Getter @Setter
        @JsonProperty("user")
        private EventUser user;
        
    }
    
}
