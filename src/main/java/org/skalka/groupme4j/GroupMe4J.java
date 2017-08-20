package org.skalka.groupme4j;

import java.util.List;

import org.skalka.groupme4j.response.Group;
import org.skalka.groupme4j.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

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
	
	public Response<List<Group>> getGroups(Integer page, Integer per_page) throws GroupMeAPIException {
		String json = null;
		
		try {
			json = Unirest.get(BASE_URL + "/groups")
			.queryString("token", token)
			.queryString("page", (page != null) ? page : 1)
			.queryString("per_page", (per_page != null) ? per_page : 10).asString().getBody();
		} catch (UnirestException UE) {
			LOGGER.error("There was an error retrieving information from GroupMe: {}", UE.getMessage());
			throw new GroupMeAPIException();
		}
		
		return convertGroupResponseJsonString(json);
	}
	
	
	// Generic Json Converter Method
	@SuppressWarnings("unchecked")
	private Response<List<Group>> convertGroupResponseJsonString(String json) {
		return (Response<List<Group>>)(new ObjectMapper()).convertValue(json, Response.class);
	}
}
