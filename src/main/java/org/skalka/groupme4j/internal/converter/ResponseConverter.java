package org.skalka.groupme4j.internal.converter;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import org.skalka.groupme4j.internal.response.GroupMeResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResponseConverter<T> {

  private static final Logger LOGGER = LoggerFactory.getLogger(ResponseConverter.class);

  private final ObjectMapper mapper = new ObjectMapper();
  private final JavaType type;

  public ResponseConverter(Class<T> clazz) {
    this.type = mapper.getTypeFactory().constructParametricType(GroupMeResponse.class, clazz);
  }

  /**
   * Parses the json string into a GroupMeResponse based on the type of converter.
   */
  public GroupMeResponse<T> parse(String json) {
    GroupMeResponse<T> response = null;

    try {
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Attempting to convert json string: {}", json);
      }
      
      response = mapper.readValue(json, type);
      
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Converted json to object: {}", response);
      }
    } catch (JsonParseException jpe) {
      LOGGER.error("Failure to parse json input, checck syntax;{}", jpe.getMessage());
    } catch (JsonMappingException jme) {
      LOGGER.error("Unable to map to the class input;{}", jme.getMessage());
    } catch (IOException ioe) {
      LOGGER.error("Failed to find json input;{}", ioe.getMessage());
    }

    return response;
  }
}
