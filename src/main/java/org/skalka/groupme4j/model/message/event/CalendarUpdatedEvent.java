package org.skalka.groupme4j.model.message.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.skalka.groupme4j.model.JacksonObject;
import org.skalka.groupme4j.model.user.EventUser;

public class CalendarUpdatedEvent extends Event {

    @Getter @Setter
    @JsonProperty("data")
    private CalendarUpdatedEventData data;
    
    public class CalendarUpdatedEventData extends JacksonObject {
        
        @Getter @Setter
        @JsonProperty("event")
        private CalendarEvent event;

        @Getter @Setter
        @JsonProperty("updated_fields")
        private List<String> updatedFields;
        
        @Getter @Setter
        @JsonProperty("user")
        private EventUser user;
        
    }
    
}
