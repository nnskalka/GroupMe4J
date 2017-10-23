package org.skalka.groupme4j.model.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ReadReceipt {

    @Getter @Setter
    @JsonProperty("chat_id")
    private String chatId;

    @Getter @Setter
    @JsonProperty("id")
    private String id;

    @Getter @Setter
    @JsonProperty("message_id")
    private String messageId;

    @Getter @Setter
    @JsonProperty("read_at")
    private Integer readAt;

    @Getter @Setter
    @JsonProperty("user_id")
    private String userId;
    
}
