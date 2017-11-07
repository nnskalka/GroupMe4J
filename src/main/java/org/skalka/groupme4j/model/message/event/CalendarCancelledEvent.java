package org.skalka.groupme4j.model.message.event;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.skalka.groupme4j.model.JacksonObject;
import org.skalka.groupme4j.model.user.EventUser;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CalendarCancelledEvent extends Event {

    @JsonProperty("data")
    private CalendarCancelledEventData data;
    
    @Data
    @NoArgsConstructor
    @EqualsAndHashCode(callSuper = true)
    public class CalendarCancelledEventData extends JacksonObject {
        
        @JsonProperty("event")
        private CalendarEventMetadata event;
        
        @JsonProperty("user")
        private EventUser user;
        
    }
    
}
