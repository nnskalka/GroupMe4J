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
public class BotDeleteEvent extends Event {
  @JsonProperty("data")
  private BotDeleteEventData data;
  
  @Data
  @NoArgsConstructor
  @EqualsAndHashCode(callSuper = true)
  public static class BotDeleteEventData extends JacksonObject {

    @JsonProperty("bot")
    private String bot;

    @JsonProperty("user")
    private EventUser user;
    
  }

}
