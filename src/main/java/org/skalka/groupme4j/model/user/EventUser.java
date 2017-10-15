package org.skalka.groupme4j.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.skalka.groupme4j.model.JacksonObject;

public class EventUser extends JacksonObject {

    @Getter @Setter
    @JsonProperty("id")
    private String id;
    
    @Getter @Setter
    @JsonProperty("nickname")
    private String nickname;
    
}
