package org.skalka.groupme4j.internal.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestConverter<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestConverter.class);
    private ObjectMapper mapper = new ObjectMapper();

    public String parseObjectRequest(T object) {
        String request = "";

        try {
            LOGGER.debug("Attempting to convert object to string: {}", object);
            request = mapper.writeValueAsString(object);
        } catch (JsonParseException JPE) {
            LOGGER.error("Failure to parse object input, check syntax;{}", JPE.getMessage());
        } catch (JsonMappingException JME) {
            LOGGER.error("Unable to map to the string output;{}", JME.getMessage());
        } catch (JsonProcessingException JPE) {
            LOGGER.error("Unable to process object;{}", JPE.getMessage());
        }

        return request;
    }
}
