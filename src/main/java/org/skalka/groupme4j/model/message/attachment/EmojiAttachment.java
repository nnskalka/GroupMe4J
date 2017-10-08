package org.skalka.groupme4j.model.message.attachment;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class EmojiAttachment extends Attachment {

    @Getter @Setter
    @JsonProperty("placeholder")
    private String placeholder;

    @Getter @Setter
    @JsonProperty("charmap")
    private List<List<Integer>> charmap;

}
