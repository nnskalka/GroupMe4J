package org.skalka.groupme4j.internal.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class GroupMeResponse<T> {

    @Getter @Setter
    @JsonProperty("meta")
    private ResponseMetadata metadata;

    @Getter @Setter
    @JsonProperty("response")
    private T response;
    
}
