package org.skalka.groupme4j.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RestfulResponse<T> {

    @JsonProperty("meta")
    private ResponseMetadata metadata;

    @JsonProperty("response")
    private T response;

    public ResponseMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(ResponseMetadata metadata) {
        this.metadata = metadata;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
