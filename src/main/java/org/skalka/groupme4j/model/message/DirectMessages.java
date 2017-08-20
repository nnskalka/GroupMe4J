package org.skalka.groupme4j.model.message;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.skalka.groupme4j.model.JacksonObject;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DirectMessages extends JacksonObject {

  @JsonProperty("count")
  private Integer count;

  @JsonProperty("direct_messages")
  private List<DirectMessage> directMessages = null;

  @JsonProperty("read_receipt")
  private ReadReceipt readReceipt;

}
