package org.skalka.groupme4j.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface RestfulResponse<T> {

    public T getResponse();

}
