package org.skalka.groupme4j.internal.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.skalka.groupme4j.model.message.attachment.Attachment;

@ToString
public class CreateBotMessageRequest {

  @Getter @Setter
  @JsonProperty("bot_id")
  private String botId;

  @Getter @Setter
  @JsonProperty("text")
  private String text;

  @Getter @Setter
  @JsonProperty("attachments")
  private List<Attachment> attachments;

}
