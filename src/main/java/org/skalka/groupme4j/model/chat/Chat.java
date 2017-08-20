package org.skalka.groupme4j.model.chat;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.skalka.groupme4j.model.JacksonObject;
import org.skalka.groupme4j.model.message.DirectMessage;
import org.skalka.groupme4j.model.user.ChatMember;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Chat extends JacksonObject {

  @JsonProperty("created_at")
  public Integer createdAt;

  @JsonProperty("last_message")
  public DirectMessage lastMessage;

  @JsonProperty("messages_count")
  public Integer messagesCount;

  @JsonProperty("other_user")
  public ChatMember otherUser;

  @JsonProperty("updated_at")
  public Integer updatedAt;

}
