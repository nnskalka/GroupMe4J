package org.skalka.groupme4j.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.skalka.groupme4j.model.message.Message;

public class CreateMessageResponse {

    @Getter @Setter
    @JsonProperty("message")
    private Message message;

}
