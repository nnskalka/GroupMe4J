package org.skalka.groupme4j.model.message.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.skalka.groupme4j.model.JacksonObject;
import org.skalka.groupme4j.model.user.EventUser;

public class MemberAddedEvent extends Event {

    @Getter @Setter
    @JsonProperty("data")
    private MemberAddedEventData data;
    
    public class MemberAddedEventData extends JacksonObject {
        
        @Getter @Setter
        @JsonProperty("added_users")
        private List<EventUser> addedUsers;
        
        @Getter @Setter
        @JsonProperty("adder_user")
        private EventUser adderUser;
        
    }
    
}
