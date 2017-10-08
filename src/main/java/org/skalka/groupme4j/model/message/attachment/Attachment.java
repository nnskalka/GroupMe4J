package org.skalka.groupme4j.model.message.attachment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.skalka.groupme4j.model.JacksonObject;

public class Attachment extends JacksonObject {

    public final static String IMAGE_TYPE = "image";
    public final static String LOCATION_TYPE = "location";
    public final static String SPLIT_TYPE = "split";
    public final static String EMOJI_TYPE = "emoji";

    @Getter @Setter
    @JsonProperty("type")
    private String type;

}
