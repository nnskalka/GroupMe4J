package org.skalka.groupme4j.model.message.attachment;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.skalka.groupme4j.model.JacksonObject;

@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME, 
  include = JsonTypeInfo.As.PROPERTY, 
  property = "type")
@JsonSubTypes({ 
  @Type(value = ImageAttachment.class, name = Attachment.IMAGE_TYPE),
  @Type(value = EmojiAttachment.class, name = Attachment.EMOJI_TYPE),
  @Type(value = MentionsAttachment.class, name = Attachment.MENTIONS_TYPE),
  @Type(value = LocationAttachment.class, name = Attachment.LOCATION_TYPE),
  @Type(value = SplitAttachment.class, name = Attachment.SPLIT_TYPE)
})
public abstract class Attachment extends JacksonObject {

    public final static String IMAGE_TYPE = "image";
    public final static String LOCATION_TYPE = "location";
    public final static String MENTIONS_TYPE = "mentions";
    public final static String SPLIT_TYPE = "split";
    public final static String EMOJI_TYPE = "emoji";

    @Getter @Setter
    @JsonProperty("type")
    private String type;

}
