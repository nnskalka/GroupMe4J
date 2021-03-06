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
public class BotAddEvent extends Event {

  @JsonProperty("data")
  private BotAddEventData data;
  
  @Data
  @NoArgsConstructor
  @EqualsAndHashCode(callSuper = true)
  public static class BotAddEventData extends JacksonObject {

    @JsonProperty("bot")
    private String bot;
    
    @JsonProperty("user")
    private EventUser user;

  }
  
}
