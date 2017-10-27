package org.skalka.groupme4j.internal.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class CreateBotMessageRequest {

    @Getter @Setter
    @JsonProperty("bot_id")
    private String botId;

    @Getter @Setter
    @JsonProperty("text")
    private String text;

    @Getter @Setter
    @JsonProperty("picture_url")
    private String pictureUrl;

}
