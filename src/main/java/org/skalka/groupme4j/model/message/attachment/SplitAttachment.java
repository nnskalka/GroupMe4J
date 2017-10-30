package org.skalka.groupme4j.model.message.attachment;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SplitAttachment extends Attachment {

    @JsonProperty("token")
    private String token;

    public SplitAttachment() {
        super();
        setType(AttachmentType.Split);
    }
    
}
