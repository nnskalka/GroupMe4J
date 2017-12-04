package org.skalka.groupme4j.model.message.attachment;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum AttachmentType {
    
    @JsonProperty(AttachmentType.AUTOKICKED_TYPE)
    Autokicked,
    
    @JsonProperty(AttachmentType.EMOJI_TYPE)
    Emoji,

    @JsonProperty(AttachmentType.EVENT_TYPE)
    Event,

    @JsonProperty(AttachmentType.FILE_TYPE)
    File,

    @JsonProperty(AttachmentType.IMAGE_TYPE)
    Image,

    @JsonProperty(AttachmentType.LINKED_IMAGE_TYPE)
    LinkedImage,

    @JsonProperty(AttachmentType.LOCATION_TYPE)
    Location,

    @JsonProperty(AttachmentType.MENTIONS_TYPE)
    Mentions,
    
    @JsonProperty(AttachmentType.POLL_TYPE)
    Poll,

    @JsonProperty(AttachmentType.POSTPROCESSING_TYPE)
    Postprocessing,

    @JsonProperty(AttachmentType.SPLIT_TYPE)
    Split,

    @JsonProperty(AttachmentType.VIDEO_TYPE)
    Video;

    // String Contants for internal reference
    public static final String AUTOKICKED_TYPE = "autokicked_member";
    public static final String EMOJI_TYPE = "emoji";
    public static final String EVENT_TYPE = "event";
    public static final String FILE_TYPE = "file";
    public static final String IMAGE_TYPE = "image";
    public static final String LINKED_IMAGE_TYPE = "linked_image";
    public static final String LOCATION_TYPE = "location";
    public static final String MENTIONS_TYPE = "mentions";
    public static final String POLL_TYPE = "poll";
    public static final String POSTPROCESSING_TYPE = "postprocessing";
    public static final String SPLIT_TYPE = "split";
    public static final String VIDEO_TYPE = "video";
    
}
