package org.skalka.groupme4j.model.message;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GroupMessage extends Message {

    @JsonProperty("group_id")
    private String groupId;

    @JsonProperty("image_url")
    private String imageUrl;

    @JsonProperty("nickname")
    private String nickname;

    @JsonProperty("system")
    private String system;

}
