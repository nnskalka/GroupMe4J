package org.skalka.groupme4j.model.message.event;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.skalka.groupme4j.model.JacksonObject;
import org.skalka.groupme4j.model.user.EventUser;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CalendarUserDeclinedEvent extends Event {

    @JsonProperty("data")
    private CalendarUserDeclinedEventData data;
    
    @Data
    @NoArgsConstructor
    @EqualsAndHashCode(callSuper = true)
    public class CalendarUserDeclinedEventData extends JacksonObject {
        
        @JsonProperty("event")
        private CalendarEvent event;

        @JsonProperty("user")
        private EventUser user;
        
    }
    
}
