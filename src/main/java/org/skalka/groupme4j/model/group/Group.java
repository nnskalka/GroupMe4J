package org.skalka.groupme4j.model.group;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.skalka.groupme4j.model.JacksonObject;
import org.skalka.groupme4j.model.user.GroupMember;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Group extends JacksonObject {

  @JsonProperty("creator_user_id")
  private String creatorUserId;

  @JsonProperty("created_at")
  private Integer createdAt;

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

  @JsonProperty("max_members")
  private Integer maxMembers;

  @JsonProperty("members")
  private List<GroupMember> members = null;

  @JsonProperty("office_mode")
  private Boolean officeMode;

  @JsonProperty("messages")
  private PreviewGroupMessage previewMessage = null;

  @JsonProperty("share_url")
  private String shareUrl;

  @JsonProperty("updated_at")
  private Integer updatedAt;

  @JsonSetter("max_members")
  public void setMaxMembers(Integer maxMembers) {
    this.maxMembers = maxMembers;
  }

  @JsonSetter("max_memberships")
  public void setMaxMemberships(Integer maxMembers) {
    this.maxMembers = maxMembers;
  }

  @JsonSetter("share_url")
  public void setShareUrl(String shareUrl) {
    this.shareUrl = shareUrl;
  }

  @JsonSetter("share_qr_code_url")
  public void setShareQrCodeUrl(String shareQrCodeUrl) {
    this.shareUrl = shareQrCodeUrl;
  }
}
