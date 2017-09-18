package org.skalka.groupme4j.converter;

import java.io.IOException;
import java.util.List;

import org.skalka.groupme4j.response.RestfulResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MultipleEntryResponseConverter<T> implements ResponseConverter<RestfulResponse<List<T>>> {

    private final static Logger LOGGER = LoggerFactory.getLogger(MultipleEntryResponseConverter.class);

    private final ObjectMapper mapper = new ObjectMapper();

    private JavaType type = null;

    public MultipleEntryResponseConverter(Class<T> clazz) {
        JavaType innerType = mapper.getTypeFactory().constructParametricType(List.class, clazz);
        this.type = mapper.getTypeFactory().constructParametricType(RestfulResponse.class, innerType);
    }

    @Override
    public RestfulResponse<List<T>> parse(String json) {
        RestfulResponse<List<T>> response = null;

        try {
            LOGGER.debug("Attempting to convert json string: {}", json);
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
