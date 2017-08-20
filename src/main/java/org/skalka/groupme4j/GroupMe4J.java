package org.skalka.groupme4j;

import java.io.IOException;

import org.skalka.groupme4j.response.group.GroupResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;

public class GroupMe4J {
	private final static Logger LOGGER = LoggerFactory.getLogger(GroupMe4J.class);
	private final static String BASE_URL = "https://api.groupme.com/v3";
	private final String token;
	
	public GroupMe4J(String token) {
		this.token = token;
	}
	
	public String getToken() {
		return this.token;
	}
	
	public GroupResponse getGroups(Integer page, Integer per_page) throws GroupMeAPIException {
		String json = null;
		GroupResponse gr = null;
		
		try {
			json = Unirest.get(BASE_URL + "/groups")
			.queryString("token", token)
			.queryString("page", (page != null) ? page : 1)
			.queryString("per_page", (per_page != null) ? per_page : 10).asString().getBody();
			
			gr = convertGroupResponseJsonString(json);
		} catch (Exception E) {
			LOGGER.error("There was an error retrieving information from GroupMe: {}", E.getMessage());
			throw new GroupMeAPIException();
		}
		
		return gr;
	}
	
	
	// Generic Json Converter Method
	private GroupResponse convertGroupResponseJsonString(String json) throws JsonParseException, JsonMappingException, IOException {
		return (new ObjectMapper()).readValue(json, GroupResponse.class);
	}
}
