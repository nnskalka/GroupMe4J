package org.skalka.groupme4j.model.message.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.skalka.groupme4j.model.JacksonObject;
import org.skalka.groupme4j.model.user.EventUser;

public class MemberExitedEvent extends Event {

    @Getter @Setter
    @JsonProperty("data")
    private MemberExitedEventData data;
    
    public class MemberExitedEventData extends JacksonObject {

        @Getter @Setter
        @JsonProperty("removed_user")
        private EventUser removedUser;

    }
    
}