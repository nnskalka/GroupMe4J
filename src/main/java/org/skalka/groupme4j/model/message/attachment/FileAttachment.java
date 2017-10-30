package org.skalka.groupme4j.model.message.attachment;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FileAttachment extends Attachment {

    @JsonProperty("file_id")
    private String fileId;
    
    public FileAttachment() {
        super();
        setType(AttachmentType.File);
    }
    
}
