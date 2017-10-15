package org.skalka.groupme4j.model.message.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.skalka.groupme4j.model.JacksonObject;

public class CalendarEvent extends JacksonObject {

    @Getter @Setter
    @JsonProperty("id")
    private String id;
    
    @Getter @Setter
    @JsonProperty("name")
    private String name;
    
}
