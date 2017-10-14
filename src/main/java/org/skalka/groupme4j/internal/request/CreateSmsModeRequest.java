package org.skalka.groupme4j.internal.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class CreateSmsModeRequest {

    @Getter @Setter
    @JsonProperty("duration")
    private Integer duration;
    
    @Getter @Setter
    @JsonProperty("registration_id")
    private String registrationId;
    
}
