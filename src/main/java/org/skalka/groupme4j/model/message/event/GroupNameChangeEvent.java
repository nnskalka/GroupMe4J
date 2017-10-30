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
public class GroupNameChangeEvent extends Event {

    @JsonProperty("data")
    private GroupNameChangeEventData data;
    
    @Data
    @NoArgsConstructor
    @EqualsAndHashCode(callSuper = true)
    public class GroupNameChangeEventData extends JacksonObject {

        @JsonProperty("name")
        private String name;
        
        @JsonProperty("user")
        private EventUser user;

    }
    
}
