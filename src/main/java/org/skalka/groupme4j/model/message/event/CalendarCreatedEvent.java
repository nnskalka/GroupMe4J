package org.skalka.groupme4j.model.message.event;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.skalka.groupme4j.model.JacksonObject;
import org.skalka.groupme4j.model.user.EventUser;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CalendarCreatedEvent extends Event {

  @JsonProperty("data")
  private CalendarCreatedEventData data;
  
  @Data
  @NoArgsConstructor
  @EqualsAndHashCode(callSuper = true)
  public static class CalendarCreatedEventData extends JacksonObject {
    
    @JsonProperty("event")
    private CalendarEventMetadata event;

    @JsonProperty("url")
    private String url;
    
    @JsonProperty("user")
    private EventUser user;
    
  }
  
}
