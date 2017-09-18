package org.skalka.groupme4j.converter;

import java.io.IOException;

import org.skalka.groupme4j.response.RestfulResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SingleEntryResponseConverter<T> implements ResponseConverter<RestfulResponse<T>>{
	private static final Logger LOGGER = LoggerFactory.getLogger(SingleEntryResponseConverter.class);
	
	private ObjectMapper mapper = new ObjectMapper();
	private JavaType type = null;
	
	public SingleEntryResponseConverter(Class<T> clazz) {
		this.type = mapper.getTypeFactory().constructParametricType(RestfulResponse.class, clazz);
	}
	
	public RestfulResponse<T> parse(String json) {
		RestfulResponse<T> response = null;
		
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
