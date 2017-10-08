package org.skalka.groupme4j.model.message;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.skalka.groupme4j.model.JacksonObject;
import org.skalka.groupme4j.model.message.attachment.Attachment;

public class Message extends JacksonObject{

    @Getter @Setter
    @JsonProperty("nickname")
    private String nickname;

    @Getter @Setter
    @JsonProperty("text")
    private String text;

    @Getter @Setter
    @JsonProperty("image_url")
    private String imageUrl;

    @Getter @Setter
    @JsonProperty("attachments")
    private List<Attachment> attachments = null;

    @Getter @Setter
    @JsonProperty("event")
    private Event event;

}
