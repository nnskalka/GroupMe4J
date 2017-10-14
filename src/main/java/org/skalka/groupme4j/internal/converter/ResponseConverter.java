package org.skalka.groupme4j.internal.converter;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.skalka.groupme4j.internal.response.GroupMeResponse;

public class ResponseConverter<T> {

    private final static Logger LOGGER = LoggerFactory.getLogger(ResponseConverter.class);

    private final ObjectMapper mapper = new ObjectMapper();
    private final JavaType type;

    public ResponseConverter(Class<T> clazz) {
        this.type = mapper.getTypeFactory().constructParametricType(GroupMeResponse.class, clazz);
    }

    public GroupMeResponse<T> parse(String json) {
        GroupMeResponse<T> response = null;

        try {
            LOGGER.trace("Attempting to convert json string: {}", json);
            response = mapper.readValue(json, type);
        } catch (JsonParseException JPE) {
            LOGGER.error("Failure to parse json input, checck syntax;{}", JPE.getMessage());
        } catch (JsonMappingException JME) {
            LOGGER.error("Unable to map to the class input;{}", JME.getMessage());
        } catch (IOException IOE) {
            LOGGER.error("Failed to find json input;{}", IOE.getMessage());
        }

        return response;
    }
}
