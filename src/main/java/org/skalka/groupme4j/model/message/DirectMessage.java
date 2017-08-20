package org.skalka.groupme4j.model.message;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DirectMessage extends Message {

  @JsonProperty("conversation_id")
  public String conversationId;

  @JsonProperty("recipient_id")
  public String recipientId;

}
