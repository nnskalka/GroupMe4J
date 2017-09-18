package org.skalka.groupme4j.model.message.attachment;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmojiAttachment extends Attachment {

    @JsonProperty("placeholder")
    private String placeholder;

    @JsonProperty("charmap")
    private List<List<Integer>> charmap;

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public List<List<Integer>> getCharmap() {
        return charmap;
    }

    public void setCharmap(List<List<Integer>> charmap) {
        this.charmap = charmap;
    }
}
