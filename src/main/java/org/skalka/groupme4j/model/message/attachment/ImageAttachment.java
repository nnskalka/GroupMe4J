package org.skalka.groupme4j.model.message.attachment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class ImageAttachment extends Attachment {

    @Getter @Setter
    @JsonProperty("source_url")
    private String sourceUrl;
    
    @Getter @Setter
    @JsonProperty("url")
    private String url;

    public ImageAttachment() {
        super();
        setType(AttachmentType.Image);
    }
    
}
