package org.skalka.groupme4j.internal.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.skalka.groupme4j.model.message.attachment.Attachment;

public class CreateDirectMessageRequest {
    
    @Getter @Setter
    @JsonProperty("direct_message")
    private MessageRequest directMessage;
    
    public class MessageRequest {
        
        @Getter @Setter
        @JsonProperty("source_guid")
        private String sourceGuid = "groupme4j-" + UUID.randomUUID().toString();
        
        @Getter @Setter
        @JsonProperty("recipient_id")
        private String recipientId;
        
        @Getter @Setter
        @JsonProperty("text")
        private String text;
        
        @Getter @Setter
        @JsonProperty("attachments")
        private List<Attachment> attachments = new ArrayList<Attachment>();
        
    }
    
}
