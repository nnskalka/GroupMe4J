package org.skalka.groupme4j.internal.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ResponseMetadata {

    @Getter @Setter
    @JsonProperty("code")
    private int code;

    @Getter @Setter
    @JsonProperty("errors")
    private List<String> errors;

}
