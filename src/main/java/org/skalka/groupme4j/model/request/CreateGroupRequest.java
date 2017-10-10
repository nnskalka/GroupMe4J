package org.skalka.groupme4j.model.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class CreateGroupRequest {

    @Getter @Setter
    @JsonProperty("name")
    private String name;

    @Getter @Setter
    @JsonProperty("description")
    private String description;

    @Getter @Setter
    @JsonProperty("image_url")
    private String imageUrl;

    @Getter @Setter
    @JsonProperty("share")
    private boolean shared;

}
