package org.skalka.groupme4j.model.chat;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.skalka.groupme4j.model.JacksonObject;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Conversation extends JacksonObject {

  @JsonProperty("id")
  private String id;

}
