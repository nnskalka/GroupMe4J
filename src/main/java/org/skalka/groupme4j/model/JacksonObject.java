package org.skalka.groupme4j.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class JacksonObject {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private Map<String, Object> otherProperties = null;

    @JsonAnyGetter
    public Object get(String key) {
        return getMap().get(key);
    }

    @JsonAnySetter
    public void set(String name, Object value) {
        LOGGER.debug("Unknown Property '{}' was registered with Value '{}'",
                name, (value != null) ? value.toString() : "null");
        
        getMap().put(name, value);
    }

    private Map<String, Object> getMap() {
        return (otherProperties != null) ? otherProperties
                : (otherProperties = new HashMap<String, Object>());
    }
    
}
