package org.skalka.groupme4j.response.group;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Group {
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("group_id")
	private String groupId;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("phone_number")
	private String phoneNumber;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("image_url")
	private String imageUrl;
	
	@JsonProperty("creator_user_id")
	private String creatorUserId;
	
	@JsonProperty("created_at")
	private int createdAt;
	
	@JsonProperty("updated_at")
	private int updatedAt;
	
	@JsonProperty("office_mode")
	private boolean officeMode;
	
	@JsonProperty("share_url")
	private String shareUrl;
	
	@JsonProperty("members")
	private List<Member> members = null;
	
	@JsonProperty("messages")
	private GroupPreviewMessage previewMessage = null;
	
	@JsonProperty("max_members")
	private int maxMembers;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getCreatorUserId() {
		return creatorUserId;
	}

	public void setCreatorUserId(String creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

	public int getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(int createdAt) {
		this.createdAt = createdAt;
	}

	public int getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(int updatedAt) {
		this.updatedAt = updatedAt;
	}

	public boolean isOfficeMode() {
		return officeMode;
	}

	public void setOfficeMode(boolean officeMode) {
		this.officeMode = officeMode;
	}

	public String getShareUrl() {
		return shareUrl;
	}

	public void setShareUrl(String shareUrl) {
		this.shareUrl = shareUrl;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public GroupPreviewMessage getPreviewMessage() {
		return previewMessage;
	}

	public void setPreviewMessage(GroupPreviewMessage previewMessage) {
		this.previewMessage = previewMessage;
	}

	public int getMaxMembers() {
		return maxMembers;
	}

	public void setMaxMembers(int maxMembers) {
		this.maxMembers = maxMembers;
	}
}
