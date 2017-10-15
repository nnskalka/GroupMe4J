package org.skalka.groupme4j.model.message.attachment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class EventAttachment extends Attachment {

    @Getter @Setter
    @JsonProperty("event_id")
    private String fileId;
    
    @Getter @Setter
    @JsonProperty("view")
    private String view;
    
}
