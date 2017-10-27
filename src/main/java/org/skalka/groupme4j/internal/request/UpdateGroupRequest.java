package org.skalka.groupme4j.internal.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class UpdateGroupRequest {

    @Getter @Setter
    @JsonProperty("name")
    private String name;

    @Getter @Setter
    @JsonProperty("image_url")
    private String imageUrl;

    @Getter @Setter
    @JsonProperty("share")
    private boolean shared;

    @Getter @Setter
    @JsonProperty("office_mode")
    private boolean officeMode;

}
