package org.skalka.groupme4j.model.group;

import org.skalka.groupme4j.model.user.GroupMember;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.skalka.groupme4j.model.JacksonObject;

@ToString
public class Group extends JacksonObject {

    @Getter @Setter
    @JsonProperty("creator_user_id")
    private String creatorUserId;

    @Getter @Setter
    @JsonProperty("created_at")
    private Integer createdAt;

    @Getter @Setter
    @JsonProperty("id")
    private String id;

    @Getter @Setter
    @JsonProperty("group_id")
    private String groupId;

    @Getter @Setter
    @JsonProperty("name")
    private String name;

    @Getter @Setter
    @JsonProperty("phone_number")
    private String phoneNumber;

    @Getter @Setter
    @JsonProperty("type")
    private String type;

    @Getter @Setter
    @JsonProperty("description")
    private String description;

    @Getter @Setter
    @JsonProperty("image_url")
    private String imageUrl;

    @Getter
    @JsonProperty("max_members")
    private Integer maxMembers;
    
    @Getter @Setter
    @JsonProperty("members")
    private List<GroupMember> members = null;

    @Getter @Setter
    @JsonProperty("office_mode")
    private Boolean officeMode;

    @Getter @Setter
    @JsonProperty("messages")
    private PreviewGroupMessage previewMessage = null;

    @Getter
    @JsonProperty("share_url")
    private String shareUrl;

    @Getter @Setter
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
