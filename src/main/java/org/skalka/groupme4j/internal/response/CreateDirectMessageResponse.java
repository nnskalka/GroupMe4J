package org.skalka.groupme4j.internal.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.skalka.groupme4j.model.message.DirectMessage;

public class CreateDirectMessageResponse {

    @Getter @Setter
    @JsonProperty("direct_message")
    private DirectMessage message;
    
}
