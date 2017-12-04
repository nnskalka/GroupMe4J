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
    property = "type",
    defaultImpl=Attachment.class)
@JsonSubTypes({
    @Type(value = AutokickedAttachment.class, name = AttachmentType.AUTOKICKED_TYPE),
    @Type(value = EmojiAttachment.class, name = AttachmentType.EMOJI_TYPE),
    @Type(value = EventAttachment.class, name = AttachmentType.EVENT_TYPE),
    @Type(value = FileAttachment.class, name = AttachmentType.FILE_TYPE),
    @Type(value = ImageAttachment.class, name = AttachmentType.IMAGE_TYPE),
    @Type(value = LinkedImageAttachment.class, name = AttachmentType.LINKED_IMAGE_TYPE),
    @Type(value = LocationAttachment.class, name = AttachmentType.LOCATION_TYPE),
    @Type(value = MentionsAttachment.class, name = AttachmentType.MENTIONS_TYPE),
    @Type(value = PollAttachment.class, name = AttachmentType.POLL_TYPE),
    @Type(value = PostprocessingAttachment.class, name = AttachmentType.POSTPROCESSING_TYPE),
    @Type(value = SplitAttachment.class, name = AttachmentType.SPLIT_TYPE),
    @Type(value = VideoAttachment.class, name = AttachmentType.VIDEO_TYPE)
})
public class Attachment extends JacksonObject {

    @Getter @Setter
    @JsonProperty(value = "type", required = true)
    private AttachmentType type;

}
