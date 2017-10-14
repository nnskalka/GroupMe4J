package org.skalka.groupme4j.model.message.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class GroupNameChangeEvent extends Event {

    @Getter @Setter
    @JsonProperty("data")
    private GroupNameChangeEventData data;
    
}
