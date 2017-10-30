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
public class MemberRemovedEvent extends Event {

    @JsonProperty("data")
    private MemberRemovedEventData data;
    
    @Data
    @NoArgsConstructor
    @EqualsAndHashCode(callSuper = true)
    public class MemberRemovedEventData extends JacksonObject {
        
        @JsonProperty("remover_user")
        private EventUser removerUser;
        
        @JsonProperty("removed_user")
        private EventUser removedUser;
        
    }
    
}
