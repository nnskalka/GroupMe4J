package org.skalka.groupme4j.model.message.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.skalka.groupme4j.model.user.EventUser;

public class GroupNameChangeEventData extends EventData {

    @Getter @Setter
    @JsonProperty("user")
    private EventUser user;

}
