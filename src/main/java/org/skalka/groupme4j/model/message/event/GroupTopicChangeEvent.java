package org.skalka.groupme4j.model.message.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.skalka.groupme4j.model.JacksonObject;
import org.skalka.groupme4j.model.user.EventUser;

public class GroupTopicChangeEvent extends Event {
    
    @Getter @Setter
    @JsonProperty("data")
    private GroupTopicChangeEventData data;
    
    public class GroupTopicChangeEventData extends JacksonObject {
        
        @Getter @Setter
        @JsonProperty("topic")
        private String topic;
        
        @Getter @Setter
        @JsonProperty("user")
        private EventUser user;
        
    }
    
}
