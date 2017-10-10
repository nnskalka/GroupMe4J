package org.skalka.groupme4j.model.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.skalka.groupme4j.model.JacksonObject;

public class Event extends JacksonObject {

    @Getter @Setter
    @JsonProperty("type")
    private String type;

    @Getter @Setter
    @JsonProperty("data")
    private EventData data;

}
