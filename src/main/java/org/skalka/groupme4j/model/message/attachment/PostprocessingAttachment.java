package org.skalka.groupme4j.model.message.attachment;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PostprocessingAttachment extends Attachment {

  @JsonProperty("queues")
  private List<String> queues;

  public PostprocessingAttachment() {
    super();
    setType(AttachmentType.Postprocessing);
  }
  
}
