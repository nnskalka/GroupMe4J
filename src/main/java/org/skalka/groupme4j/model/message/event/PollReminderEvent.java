package org.skalka.groupme4j.model.message.event;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.skalka.groupme4j.model.chat.Conversation;
import org.skalka.groupme4j.model.poll.Poll;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PollReminderEvent extends Event {
    
    @JsonProperty("data")
    private PollReminderEventData data;

    public class PollReminderEventData {

        @JsonProperty("conversation")
        private Conversation conversation;

        @JsonProperty("poll")
        private Poll poll;
    }
    
}
