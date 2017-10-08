package org.skalka.groupme4j.model.group;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.skalka.groupme4j.model.JacksonObject;

public class Group extends JacksonObject{

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

    @Getter @Setter
    @JsonProperty("creator_user_id")
    private String creatorUserId;

    @Getter @Setter
    @JsonProperty("created_at")
    private int createdAt;

    @Getter @Setter
    @JsonProperty("updated_at")
    private int updatedAt;

    @Getter @Setter
    @JsonProperty("office_mode")
    private boolean officeMode;

    @Getter @Setter
    @JsonProperty("share_url")
    private String shareUrl;

    @Getter @Setter
    @JsonProperty("members")
    private List<Member> members = null;

    @Getter @Setter
    @JsonProperty("messages")
    private GroupPreviewMessage previewMessage = null;

    @Getter @Setter
    @JsonProperty("max_members")
    private int maxMembers;

}
