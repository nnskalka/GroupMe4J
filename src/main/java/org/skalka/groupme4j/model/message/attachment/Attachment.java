package org.skalka.groupme4j.model.message.attachment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Attachment {
    public final static String IMAGE_TYPE = "image";
    public final static String LOCATION_TYPE = "location";
    public final static String SPLIT_TYPE = "split";
    public final static String EMOJI_TYPE = "emoji";

    @JsonProperty("type")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}