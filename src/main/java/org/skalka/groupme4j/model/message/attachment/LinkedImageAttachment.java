package org.skalka.groupme4j.model.message.attachment;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class LinkedImageAttachment extends Attachment {

    @JsonProperty("url")
    private String url;
    
    public LinkedImageAttachment() {
        super();
        setType(AttachmentType.LinkedImage);
    }
}
