package org.skalka.groupme4j.model.message.attachment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class VideoAttachment extends Attachment {
    
    @Getter @Setter
    @JsonProperty ("url")
    private String url;
    
    @Getter @Setter
    @JsonProperty ("preview_url")
    private String previewUrl;
    
    public VideoAttachment() {
        super();
        setType(AttachmentType.Video);
    }
    
}
