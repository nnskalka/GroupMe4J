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
public class MemberExitedEvent extends Event {

    @JsonProperty("data")
    private MemberExitedEventData data;
    
    @Data
    @NoArgsConstructor
    @EqualsAndHashCode(callSuper = true)
    public class MemberExitedEventData extends JacksonObject {

        @JsonProperty("removed_user")
        private EventUser removedUser;

    }
    
}
