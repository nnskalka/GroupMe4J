package org.skalka.groupme4j.model.poll;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.skalka.groupme4j.model.JacksonObject;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Option extends JacksonObject {

  @JsonProperty("id")
  private String id;
  
  @JsonProperty("title")
  private String title;
  
  @JsonProperty("votes")
  private Integer votes;

}
