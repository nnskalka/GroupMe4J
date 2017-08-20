package org.skalka.groupme4j.internal.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.skalka.groupme4j.model.bot.Bot;

@ToString
public class CreateBotResponse {

  @Getter @Setter
  @JsonProperty("bot")
  private Bot bot;

}
