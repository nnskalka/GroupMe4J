package org.skalka.groupme4j.model.message.attachment;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class EventAttachment extends Attachment {

  @JsonProperty("event_id")
  private String fileId;
  
  @JsonProperty("view")
  private String view;
  
  public EventAttachment() {
    super();
    setType(AttachmentType.Event);
  }
  
}
