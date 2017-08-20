package org.skalka.groupme4j.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
	@JsonProperty("nickname")
	private String nickname;
	
	@JsonProperty("text")
	private String text;
	
	@JsonProperty("image_url")
	private String imageUrl;
	
	@JsonProperty("attachments")
	private List<Object> attachments = null;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<Object> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Object> attachments) {
		this.attachments = attachments;
	}
}
