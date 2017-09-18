package org.skalka.groupme4j.model.group;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.skalka.groupme4j.model.JacksonObject;

public class Member extends JacksonObject {

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

    @JsonProperty("autokicked")
    private boolean autokicked;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isMuted() {
        return muted;
    }

    public void setMuted(boolean muted) {
        this.muted = muted;
    }

    public boolean isAutokicked() {
        return autokicked;
    }

    public void setAutokicked(boolean autokicked) {
        this.autokicked = autokicked;
    }
}
