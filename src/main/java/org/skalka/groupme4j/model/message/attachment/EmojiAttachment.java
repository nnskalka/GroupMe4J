package org.skalka.groupme4j.model.message.attachment;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class EmojiAttachment extends Attachment {

    @JsonProperty("placeholder")
    private String placeholder;

    @JsonProperty("charmap")
    private List<List<Integer>> charmap;

    public EmojiAttachment() {
        super();
        setType(AttachmentType.Emoji);
    }
    
}
