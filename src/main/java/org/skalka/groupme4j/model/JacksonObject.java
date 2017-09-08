package org.skalka.groupme4j.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JacksonObject {
    private final Logger LOGGER = LoggerFactory.getLogger(JacksonObject.class);
    private Map<String, Object> otherProperties = new HashMap<String, Object>();
    
    @JsonAnyGetter
    public Object get(String key) {
        return otherProperties.get(key);
    }

    @JsonAnySetter
    public void set(String name, Object value) {
        LOGGER.debug("Unknown Property '{}' was registered with Value '{}'", name, (value != null) ? value.toString() : "null" );
        otherProperties.put(name, value);
    }
}