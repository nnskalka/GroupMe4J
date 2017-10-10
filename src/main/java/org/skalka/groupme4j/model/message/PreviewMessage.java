package org.skalka.groupme4j.model.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.skalka.groupme4j.model.JacksonObject;

public class PreviewMessage extends JacksonObject {

    @Getter @Setter
    @JsonProperty("count")
    private Integer count;

    @Getter @Setter
    @JsonProperty("last_message_id")
    private String lastMessageId;

    @Getter @Setter
    @JsonProperty("last_message_created_at")
    private Integer lastMessageCreatedAt;

    @Getter @Setter
    @JsonProperty("preview")
    private GroupMessage preview;

}
