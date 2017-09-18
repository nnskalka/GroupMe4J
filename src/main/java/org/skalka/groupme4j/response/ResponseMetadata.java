package org.skalka.groupme4j.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseMetadata {

    @JsonProperty("code")
    private int code;

    @JsonProperty("errors")
    private List<String> errors;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
