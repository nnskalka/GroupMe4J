package org.skalka.groupme4j.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.skalka.groupme4j.model.message.attachment.Attachment;

public class CreateMessageRequest {

    @Getter @Setter
    @JsonProperty("message")
    private MessageRequest message;

    public class MessageRequest {
        
        @Getter @Setter
        @JsonProperty("source_guid")
        private String sourceGuid = UUID.randomUUID().toString();
        
        @Getter @Setter
        @JsonProperty("text")
        private String text;
        
        @Getter @Setter
        @JsonProperty("attachments")
        private List<Attachment> attachments = new ArrayList<Attachment>();

    }

}
