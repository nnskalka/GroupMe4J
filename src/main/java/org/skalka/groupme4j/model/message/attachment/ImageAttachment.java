package org.skalka.groupme4j.model.message.attachment;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ImageAttachment extends Attachment {

    @JsonProperty("source_url")
    private String sourceUrl;
    
    @JsonProperty("url")
    private String url;

    public ImageAttachment() {
        super();
        setType(AttachmentType.Image);
    }
    
}
