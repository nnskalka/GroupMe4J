package org.skalka.groupme4j.model.message.event;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.skalka.groupme4j.model.JacksonObject;
import org.skalka.groupme4j.model.user.EventUser;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MemberAddedEvent extends Event {

  @JsonProperty("data")
  private MemberAddedEventData data;
  
  @Data
  @NoArgsConstructor
  @EqualsAndHashCode(callSuper = true)
  public static class MemberAddedEventData extends JacksonObject {
    
    @JsonProperty("added_users")
    private List<EventUser> addedUsers;
    
    @JsonProperty("adder_user")
    private EventUser adderUser;
    
  }
  
}
