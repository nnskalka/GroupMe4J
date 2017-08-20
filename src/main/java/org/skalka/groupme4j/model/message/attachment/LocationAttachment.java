package org.skalka.groupme4j.model.message.attachment;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class LocationAttachment extends Attachment {

  @JsonProperty("lat")
  private String latitude;

  @JsonProperty("lng")
  private String longitude;

  @JsonProperty("name")
  private String name;
  
  public LocationAttachment() {
    super();
    setType(AttachmentType.Location);
  }

}
