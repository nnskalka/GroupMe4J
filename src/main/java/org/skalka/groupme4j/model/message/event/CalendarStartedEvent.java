package org.skalka.groupme4j.model.message.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.skalka.groupme4j.model.JacksonObject;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CalendarStartedEvent extends Event {
    
    @JsonProperty("data")
    private CalendarStartedEventData data;
    
    @Data
    @NoArgsConstructor
    @EqualsAndHashCode(callSuper = true)
    public class CalendarStartedEventData extends JacksonObject {
        
        @JsonProperty("event_name")
        private String eventName;
        
        @JsonProperty("minutes")
        private Integer minutes;
        
    }
    
}
