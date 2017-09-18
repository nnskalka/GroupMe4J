package org.skalka.groupme4j.request.group;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateGroupRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("image_url")
    private String imageUrl;

    @JsonProperty("share")
    private boolean shared;

    @JsonProperty("office_mode")
    private boolean officeMode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean isOfficeMode() {
        return officeMode;
    }

    public void setOfficeMode(boolean officeMode) {
        this.officeMode = officeMode;
    }
}
