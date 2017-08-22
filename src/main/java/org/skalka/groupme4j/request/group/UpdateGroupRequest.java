package org.skalka.groupme4j.request.group;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateGroupRequest {
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("description")
	private String description;

	@JsonProperty("image_url")
	private String imageUrl;

	@JsonProperty("share")
	private boolean shared;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public boolean isShared() {
		return shared;
	}

	public void setShared(boolean share) {
		this.shared = share;
	}
}
