package org.skalka.groupme4j.model.message.attachment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class PollAttachment extends Attachment {
    
    @Getter @Setter
    @JsonProperty("poll_id")
    private String pollId;
    
    public PollAttachment() {
        super();
        setType(AttachmentType.Poll);
    }
    
}
