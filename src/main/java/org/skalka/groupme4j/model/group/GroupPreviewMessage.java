package org.skalka.groupme4j.model.group;

import org.skalka.groupme4j.model.message.Message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class GroupPreviewMessage {

    @Getter @Setter
    @JsonProperty("count")
    private int count;

    @Getter @Setter
    @JsonProperty("last_message_id")
    private String lastMessageId;

    @Getter @Setter
    @JsonProperty("last_message_created_at")
    private int lastMessageCreatedAt;

    @Getter @Setter
    @JsonProperty("preview")
    private Message preview;

}
