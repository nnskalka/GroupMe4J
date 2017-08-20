package org.skalka.groupme4j.internal.converter;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestConverter<T> {

  private static final Logger LOGGER = LoggerFactory.getLogger(RequestConverter.class);
  private final ObjectMapper mapper = new ObjectMapper();

  /**
   * Parses object of type similar ot the converter into a GroupMe API readable string.
   */
  public String parseObjectRequest(T object) {
    String json = "";

    try {
      json = mapper.writeValueAsString(object).trim();
      
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Attempting to convert object to string: {}", json);
      }
    } catch (JsonParseException jpe) {
      LOGGER.error("Failure to parse object input, check syntax;{}", jpe.getMessage());
    } catch (JsonMappingException jme) {
      LOGGER.error("Unable to map to the string output;{}", jme.getMessage());
    } catch (JsonProcessingException jpe) {
      LOGGER.error("Unable to process object;{}", jpe.getMessage());
    }

    return json;
  }
}
