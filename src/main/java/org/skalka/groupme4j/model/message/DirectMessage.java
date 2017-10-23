package org.skalka.groupme4j.model.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class DirectMessage extends Message {
    
    @Getter @Setter
    @JsonProperty("conversation_id")
    public String conversationId;
    
    @Getter @Setter
    @JsonProperty("recipient_id")
    public String recipientId;
    
}
