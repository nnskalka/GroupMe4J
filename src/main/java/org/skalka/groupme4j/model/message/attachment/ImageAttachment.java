package org.skalka.groupme4j.model.message.attachment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class ImageAttachment extends Attachment {

    @Getter @Setter
    @JsonProperty("url")
    private String url;

}
