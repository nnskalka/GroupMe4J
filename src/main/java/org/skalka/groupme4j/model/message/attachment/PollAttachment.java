package org.skalka.groupme4j.model.message.attachment;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PollAttachment extends Attachment {
    
    @JsonProperty("poll_id")
    private String pollId;
    
    public PollAttachment() {
        super();
        setType(AttachmentType.Poll);
    }
    
}
