package org.skalka.groupme4j.model.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.skalka.groupme4j.model.JacksonObject;
import org.skalka.groupme4j.model.message.DirectMessage;
import org.skalka.groupme4j.model.user.ChatMember;

public class Chat extends JacksonObject {

    @Getter @Setter
    @JsonProperty("created_at")
    public Integer createdAt;

    @Getter @Setter
    @JsonProperty("last_message")
    public DirectMessage lastMessage;

    @Getter @Setter
    @JsonProperty("messages_count")
    public Integer messagesCount;

    @Getter @Setter
    @JsonProperty("other_user")
    public ChatMember otherUser;

    @Getter @Setter
    @JsonProperty("updated_at")
    public Integer updatedAt;
    
}
