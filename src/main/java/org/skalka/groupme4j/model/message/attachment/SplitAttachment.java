package org.skalka.groupme4j.model.message.attachment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class SplitAttachment extends Attachment {

    @Getter @Setter
    @JsonProperty("token")
    private String token;

}
