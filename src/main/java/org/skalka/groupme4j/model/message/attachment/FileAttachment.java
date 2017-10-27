package org.skalka.groupme4j.model.message.attachment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class FileAttachment extends Attachment {

    @Getter @Setter
    @JsonProperty("file_id")
    private String fileId;
    
    public FileAttachment() {
        super();
        setType(AttachmentType.File);
    }
    
}
