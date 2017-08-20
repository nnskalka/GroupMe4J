package org.skalka.groupme4j.response.group;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseMetadata {
	@JsonProperty("code")
	private Integer code;
	
	@JsonProperty("errors")
	private List<String> errors;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
}
