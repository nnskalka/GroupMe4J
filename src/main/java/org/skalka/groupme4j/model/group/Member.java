package org.skalka.groupme4j.model.group;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import org.skalka.groupme4j.model.JacksonObject;

public class Member extends JacksonObject {

    @Getter @Setter
    @JsonProperty("user_id")
    private String userId;

    @Getter @Setter
    @JsonProperty("nickname")
    private String nickname;

    @Getter @Setter
    @JsonProperty("image_url")
    private String imageUrl;

    @Getter @Setter
    @JsonProperty("id")
    private String id;

    @Getter @Setter
    @JsonProperty("muted")
    private boolean muted;

    @Getter @Setter
    @JsonProperty("autokicked")
    private boolean autokicked;

}
