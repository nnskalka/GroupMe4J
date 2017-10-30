package org.skalka.groupme4j.model.group;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.skalka.groupme4j.model.JacksonObject;
import org.skalka.groupme4j.model.message.GroupMessage;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PreviewGroupMessage extends JacksonObject {

    @JsonProperty("count")
    private Integer count;

    @JsonProperty("last_message_id")
    private String lastMessageId;

    @JsonProperty("last_message_created_at")
    private Integer lastMessageCreatedAt;

    @JsonProperty("preview")
    private GroupMessage preview;

}
