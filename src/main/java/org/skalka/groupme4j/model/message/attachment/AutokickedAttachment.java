package org.skalka.groupme4j.model.message.attachment;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AutokickedAttachment extends Attachment {

  @JsonProperty("user_id")
  private String userId;

  public AutokickedAttachment() {
    super();
    setType(AttachmentType.Emoji);
  }

}
