package org.skalka.groupme4j.model.message.attachment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class LinkedImageAttachment extends Attachment {

    @Getter @Setter
    @JsonProperty("url")
    private String url;
    
}
