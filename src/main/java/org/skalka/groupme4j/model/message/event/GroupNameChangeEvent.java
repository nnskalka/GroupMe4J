package org.skalka.groupme4j.model.message.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.skalka.groupme4j.model.JacksonObject;
import org.skalka.groupme4j.model.user.EventUser;

public class GroupNameChangeEvent extends Event {

    @Getter @Setter
    @JsonProperty("data")
    private GroupNameChangeEventData data;
    
    public class GroupNameChangeEventData extends JacksonObject {

        @Getter @Setter
        @JsonProperty("name")
        private String name;
        
        @Getter @Setter
        @JsonProperty("user")
        private EventUser user;

    }
    
}
