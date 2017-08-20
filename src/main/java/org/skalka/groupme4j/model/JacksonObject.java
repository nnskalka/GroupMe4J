package org.skalka.groupme4j.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode
public abstract class JacksonObject {

  private static final Logger LOGGER = LoggerFactory.getLogger(JacksonObject.class);
  private Map<String, Object> otherProperties = null;

  /**
   * Getter for all properties not found in a subclasses field.
   */
  @JsonAnyGetter
  public Object get(String key) {
    return getMap().get(key);
  }

  /**
   * Setter for any property not caught directly by a field.
   */
  @JsonAnySetter
  public void setProperty(String name, Object value) {
    LOGGER.debug(this.getClass() + ": Unknown Property '{}' was registered with Value '{}'",
        name, (value != null) ? value.toString() : "null");

    getMap().put(name, value);
  }

  private Map<String, Object> getMap() {
    return (otherProperties != null) ? otherProperties
        : (otherProperties = new HashMap<String, Object>());
  }

}
