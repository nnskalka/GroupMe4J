package org.skalka.groupme4j.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GroupPreviewMessage {
	@JsonProperty("count")
	private int count;
	
	@JsonProperty("last_message_id")
	private String lastMessageId;
	
	@JsonProperty("last_message_created_at")
	private int lastMessageCreatedAt;
	
	@JsonProperty("preview")
	private Message preview;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getLastMessageId() {
		return lastMessageId;
	}

	public void setLastMessageId(String lastMessageId) {
		this.lastMessageId = lastMessageId;
	}

	public int getLastMessageCreatedAt() {
		return lastMessageCreatedAt;
	}

	public void setLastMessageCreatedAt(int lastMessageCreatedAt) {
		this.lastMessageCreatedAt = lastMessageCreatedAt;
	}

	public Message getPreview() {
		return preview;
	}

	public void setPreview(Message preview) {
		this.preview = preview;
	}
}
