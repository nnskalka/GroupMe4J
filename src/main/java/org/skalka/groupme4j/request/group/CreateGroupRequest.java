package org.skalka.groupme4j.request.group;

import org.skalka.groupme4j.exception.GroupMeAPIException;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateGroupRequest {

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

    public void setName(String name) throws GroupMeAPIException {
        if (name.length() > 140) {
            throw new GroupMeAPIException(/* Name Length Too Long */);
        }

        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws GroupMeAPIException {
        if (name.length() > 255) {
            throw new GroupMeAPIException(/* Description Length Too Long */);
        }

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
