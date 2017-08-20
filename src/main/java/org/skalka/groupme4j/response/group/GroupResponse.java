package org.skalka.groupme4j.response.group;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GroupResponse {
	@JsonProperty("meta")
	private ResponseMetadata metadata; 
	
	@JsonProperty("response")
	private List<Group> response;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	public ResponseMetadata getMetadata() {
		return metadata;
	}

	public void setMetadata(ResponseMetadata metadata) {
		this.metadata = metadata;
	}

	public List<Group> getResponse() {
		return response;
	}

	public void setResponse(List<Group> response) {
		this.response = response;
	}
	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}
}
