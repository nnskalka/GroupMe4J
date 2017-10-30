package org.skalka.groupme4j.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.skalka.groupme4j.model.JacksonObject;

@Data
@EqualsAndHashCode(callSuper = true)
public class GroupMember extends JacksonObject {

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("nickname")
    private String nickname;

    @JsonProperty("image_url")
    private String imageUrl;

    @JsonProperty("id")
    private String id;

    @JsonProperty("muted")
    private boolean muted;

    @JsonProperty("roles")
    private List<String> roles;
    
    @JsonProperty("autokicked")
    private boolean autokicked;

}
