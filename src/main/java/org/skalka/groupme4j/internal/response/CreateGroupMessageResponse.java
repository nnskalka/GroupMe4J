package org.skalka.groupme4j.internal.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.skalka.groupme4j.model.message.GroupMessage;

public class CreateGroupMessageResponse {

    @Getter @Setter
    @JsonProperty("message")
    private GroupMessage message;

}
