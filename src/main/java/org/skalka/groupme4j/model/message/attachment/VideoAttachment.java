package org.skalka.groupme4j.model.message.attachment;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class VideoAttachment extends Attachment {

    @JsonProperty ("url")
    private String url;

    @JsonProperty ("preview_url")
    private String previewUrl;
    
    public VideoAttachment() {
        super();
        setType(AttachmentType.Video);
    }
    
}
