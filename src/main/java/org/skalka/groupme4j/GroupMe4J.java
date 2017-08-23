package org.skalka.groupme4j;

import java.util.List;

import org.skalka.groupme4j.converter.MultipleEntryResponseConverter;
import org.skalka.groupme4j.converter.RequestConverter;
import org.skalka.groupme4j.converter.SingleEntryResponseConverter;
import org.skalka.groupme4j.exception.GroupMeAPIException;
import org.skalka.groupme4j.request.group.CreateGroupRequest;
import org.skalka.groupme4j.response.group.Group;
import org.skalka.groupme4j.response.group.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	
	public List<Group> getGroups(Integer page, Integer per_page) throws GroupMeAPIException {
		Response<List<Group>> response = null;
		
		try {
			LOGGER.debug("Connecting to: '{}'", BASE_URL + "/groups");
			String json = Unirest.get(BASE_URL + "/groups")
			.queryString("token", token)
			.queryString("page", (page != null) ? page : 1)
			.queryString("per_page", (per_page != null) ? per_page : 10)
			.asString().getBody();
			
			MultipleEntryResponseConverter<Group> mec = new MultipleEntryResponseConverter<Group>(Group.class);
			response = mec.parseJsonResponse(json);
		} catch (Exception E) {
			LOGGER.error("There was an error retrieving information from GroupMe: {}", E.getMessage());
			throw new GroupMeAPIException();
		}
		
		return response.getResponse();
	}
	
	public List<Group> getFormerGroups() throws GroupMeAPIException {
		Response<List<Group>> response = null;
		
		try {
			LOGGER.debug("Connecting to: '{}'", BASE_URL + "/groups/former");
			String json = Unirest.get(BASE_URL + "/groups/former")
			.queryString("token", token)
			.asString().getBody();
			
			MultipleEntryResponseConverter<Group> mec = new MultipleEntryResponseConverter<Group>(Group.class);
			response = mec.parseJsonResponse(json);
		} catch (Exception E) {
			LOGGER.error("There was an error retrieving information from GroupMe: {}", E.getMessage());
			throw new GroupMeAPIException();
		}
		
		return response.getResponse();
	}
	
	public Group getGroupById(String id) throws GroupMeAPIException {
		Response<Group> response = null;
		
		try {
			LOGGER.debug("Connecting to: '{}'", BASE_URL + "/groups/" + id);
			String json = Unirest.get(BASE_URL + "/groups/" + id)
			.queryString("token", token)
			.asString().getBody();
			
			SingleEntryResponseConverter<Group> sec = new SingleEntryResponseConverter<Group>(Group.class);
			response = sec.parseJsonResponse(json);
		} catch (Exception E) {
			LOGGER.error("There was an error retrieving information from GroupMe: {}", E.getMessage());
			throw new GroupMeAPIException();
		}
		
		return response.getResponse();
	}
	
	public Group createGroup(String name) throws GroupMeAPIException {
		return createGroup(name, null, null, false);
	}
	
	public Group createGroup(String name, String description, String imageUrl, boolean share) throws GroupMeAPIException {
		Response<Group> response = null;
		
		if (name.length() > 140) {
			throw new GroupMeAPIException();
		}
		
		try {
			CreateGroupRequest request = new CreateGroupRequest();
			request.setName(name);
			request.setDescription(description);
			request.setImageUrl(imageUrl);
			request.setShared(share);
			
			RequestConverter<CreateGroupRequest> rc = new RequestConverter<CreateGroupRequest>();
			LOGGER.debug("Connecting to: '{}'", BASE_URL + "/groups");
			String json = Unirest.post(BASE_URL + "/groups")
			.header("X-Access-Token", token)
			.body(rc.parseObjectRequest(request))
			.asString().getBody();
			
			SingleEntryResponseConverter<Group> sec = new SingleEntryResponseConverter<Group>(Group.class);
			response = sec.parseJsonResponse(json);
		} catch (Exception E) {
			LOGGER.error("There was an error retrieving information from GroupMe: {}", E.getMessage());
			throw new GroupMeAPIException();
		}
		
		return response.getResponse();
	}
	
	public boolean destoryGroup(String id) throws GroupMeAPIException {
		Integer responseCode = null;
		
		try {
			LOGGER.debug("Connecting to: '{}'", BASE_URL + "/groups/" + id + "/destroy");
			responseCode = Unirest.post(BASE_URL + "/groups/" + id + "/destroy")
			.header("X-Access-Token", token)
			.asString().getStatus();
		} catch (Exception E) {
			LOGGER.error("There was an error retrieving information from GroupMe: {}", E.getMessage());
			throw new GroupMeAPIException();
		}
		
		return (responseCode.intValue() == 200);
	}
}
