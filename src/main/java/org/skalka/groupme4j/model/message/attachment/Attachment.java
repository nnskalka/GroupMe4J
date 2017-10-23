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
  @Type(value = EmojiAttachment.class, name = Attachment.EMOJI_TYPE),
  @Type(value = EventAttachment.class, name = Attachment.EVENT_TYPE),
  @Type(value = FileAttachment.class, name = Attachment.FILE_TYPE),
  @Type(value = ImageAttachment.class, name = Attachment.IMAGE_TYPE),
  @Type(value = LinkedImageAttachment.class, name = Attachment.LINKED_IMAGE_TYPE),
  @Type(value = LocationAttachment.class, name = Attachment.LOCATION_TYPE),
  @Type(value = MentionsAttachment.class, name = Attachment.MENTIONS_TYPE),
  @Type(value = PostprocessingAttachment.class, name = Attachment.POSTPROCESSING_TYPE),
  @Type(value = SplitAttachment.class, name = Attachment.SPLIT_TYPE),
  @Type(value = VideoAttachment.class, name = Attachment.VIDEO_TYPE)
})
public abstract class Attachment extends JacksonObject {

    public final static String EMOJI_TYPE = "emoji";
    public final static String EVENT_TYPE = "event";
    public final static String FILE_TYPE = "file";
    public final static String IMAGE_TYPE = "image";
    public final static String LINKED_IMAGE_TYPE = "linked_image";
    public final static String LOCATION_TYPE = "location";
    public final static String MENTIONS_TYPE = "mentions";
    public final static String POSTPROCESSING_TYPE = "postprocessing";
    public final static String SPLIT_TYPE = "split";
    public final static String VIDEO_TYPE = "video";
    
    @Getter @Setter
    @JsonProperty("type")
    private String type;

}
