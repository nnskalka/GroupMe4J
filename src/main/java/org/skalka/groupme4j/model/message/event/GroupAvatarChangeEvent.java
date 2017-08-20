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
public class GroupAvatarChangeEvent extends Event {
  
  @JsonProperty("data")
  private GroupAvatarChangeEventData data;
  
  @Data
  @NoArgsConstructor
  @EqualsAndHashCode(callSuper = true)
  public static class GroupAvatarChangeEventData extends JacksonObject {
    
    @JsonProperty("avatar_url")
    private String avatarUrl;
    
    @JsonProperty("user")
    private EventUser user;
    
  }
  
}
