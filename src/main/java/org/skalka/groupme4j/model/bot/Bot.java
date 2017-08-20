package org.skalka.groupme4j.model.bot;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.skalka.groupme4j.model.JacksonObject;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Bot extends JacksonObject {

  @JsonProperty("avatar_url")
  private String avatarUrl;

  @JsonProperty("bot_id")
  private String botId;

  @JsonProperty("callback_url")
  private String callbackUrl;

  @JsonProperty("dm_notification")
  private Boolean dmNotification;

  @JsonProperty("group_id")
  private String groupId;

  @JsonProperty("group_name")
  private String groupName;

  @JsonProperty("name")
  private String name;

}
