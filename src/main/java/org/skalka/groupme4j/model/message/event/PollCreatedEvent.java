package org.skalka.groupme4j.model.message.event;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.skalka.groupme4j.model.chat.Conversation;
import org.skalka.groupme4j.model.poll.Poll;
import org.skalka.groupme4j.model.user.EventUser;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PollCreatedEvent extends Event {

    @JsonProperty("data")
    private PollEndedEventData data;

    public class PollEndedEventData {

        @JsonProperty("conversation")
        private Conversation conversation;

        @JsonProperty("poll")
        private Poll poll;

        @JsonProperty("user")
        private EventUser user;
    }
}
