package org.skalka.groupme4j.model.message;

import org.skalka.groupme4j.model.message.event.Event;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.skalka.groupme4j.model.JacksonObject;
import org.skalka.groupme4j.model.message.attachment.Attachment;

public abstract class Message extends JacksonObject {
    
    @Getter @Setter
    @JsonProperty("attachments")
    private List<Attachment> attachments = null;

    @Getter @Setter
    @JsonProperty("avatar_url")
    private String avatarUrl;
    
    @Getter @Setter
    @JsonProperty("created_at")
    private Long createdAt;

    @Getter @Setter
    @JsonProperty("event")
    private Event event;
    
    @Getter @Setter
    @JsonProperty("favorited_by")
    private List<Object> favoritedBy = null;

    @Getter @Setter
    @JsonProperty("id")
    private String id;
    
    @Getter @Setter
    @JsonProperty("name")
    private String name;
    
    @Getter @Setter
    @JsonProperty("sender_id")
    private String senderId;
    
    @Getter @Setter
    @JsonProperty("sender_type")
    private String senderType;
    
    @Getter @Setter
    @JsonProperty("source_guid")
    private String sourceGuid;
    
    @Getter @Setter
    @JsonProperty("text")
    private String text;

    @Getter @Setter
    @JsonProperty("user_id")
    private String userId;
    
}
