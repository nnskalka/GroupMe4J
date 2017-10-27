package org.skalka.groupme4j.model.message.attachment;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class PostprocessingAttachment extends Attachment {

    @Getter @Setter
    @JsonProperty("queues")
    private List<String> queues;

    public PostprocessingAttachment() {
        super();
        setType(AttachmentType.Postprocessing);
    }
    
}
