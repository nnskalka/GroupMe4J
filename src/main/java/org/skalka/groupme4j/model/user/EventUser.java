package org.skalka.groupme4j.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.skalka.groupme4j.model.JacksonObject;

@Data
@EqualsAndHashCode(callSuper = true)
public class EventUser extends JacksonObject {
  
  @JsonProperty("id")
  private String id;
   
  @JsonProperty("nickname")
  private String nickname;
  
}
