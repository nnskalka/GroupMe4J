package org.skalka.groupme4j.model.message.attachment;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MentionsAttachment extends Attachment {

  @JsonProperty("loci")
  private List<List<Integer>> loci = null;
  
  @JsonProperty("user_ids")
  private List<String> userIds = null;

  public MentionsAttachment() {
    super();
    setType(AttachmentType.Mentions);
  }
  
}
