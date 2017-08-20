package org.skalka.groupme4j.model.message.event;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.skalka.groupme4j.model.JacksonObject;
import org.skalka.groupme4j.model.chat.Conversation;
import org.skalka.groupme4j.model.poll.Option;
import org.skalka.groupme4j.model.poll.Poll;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PollEndedEvent extends Event {

  @JsonProperty("data")
  private PollEndedEventData data;

  @Data
  @NoArgsConstructor
  @EqualsAndHashCode(callSuper = true)
  public static class PollEndedEventData extends JacksonObject {

    @JsonProperty("conversation")
    private Conversation conversation;

    @JsonProperty("options")
    private List<Option> options = null;

    @JsonProperty("poll")
    private Poll poll;
  }
}
