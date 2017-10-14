package org.skalka.groupme4j.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class EventUser {

    @Getter @Setter
    @JsonProperty("id")
    private String id;
    
    @Getter @Setter
    @JsonProperty("nickname")
    private String nickname;
    
}
