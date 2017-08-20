package org.skalka.groupme4j.model.message;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;

import org.skalka.groupme4j.model.JacksonObject;
import org.skalka.groupme4j.model.message.attachment.Attachment;
import org.skalka.groupme4j.model.message.event.Event;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public abstract class Message extends JacksonObject {

  @JsonProperty("attachments")
  private List<Attachment> attachments;

  @JsonProperty("avatar_url")
  private String avatarUrl;

  @JsonProperty("created_at")
  private Long createdAt;

  @JsonProperty("event")
  private Event event;

  @JsonProperty("favorited_by")
  private List<Object> favoritedBy;

  @JsonProperty("id")
  private String id;

  @JsonProperty("liked_at")
  private DateTime likedAt;

  @JsonProperty("name")
  private String name;

  @JsonProperty("sender_id")
  private String senderId;

  @JsonProperty("sender_type")
  private String senderType;

  @JsonProperty("source_guid")
  private String sourceGuid;

  @JsonProperty("text")
  private String text;

  @JsonProperty("user_id")
  private String userId;

  @JsonProperty("liked_at")
  public void setLikedAt(String dateTime) {
    this.likedAt = DateTime.parse(dateTime, ISODateTimeFormat.dateTimeParser());
  }

  public void setLikedAt(DateTime dateTime) {
    this.likedAt = dateTime;
  }

}
