package org.skalka.groupme4j.model.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.skalka.groupme4j.model.JacksonObject;

public class EventData extends JacksonObject {

    @Getter @Setter
    @JsonProperty("event_name")
    private String eventName;

    @Getter @Setter
    @JsonProperty("minutes")
    private String minutes;

}
