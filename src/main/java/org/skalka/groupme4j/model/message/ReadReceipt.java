package org.skalka.groupme4j.model.message;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.skalka.groupme4j.model.JacksonObject;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ReadReceipt extends JacksonObject {

  @JsonProperty("chat_id")
  private String chatId;

  @JsonProperty("id")
  private String id;

  @JsonProperty("message_id")
  private String messageId;

  @JsonProperty("read_at")
  private Integer readAt;

  @JsonProperty("user_id")
  private String userId;

}
