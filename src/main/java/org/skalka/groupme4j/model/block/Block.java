package org.skalka.groupme4j.model.block;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.skalka.groupme4j.model.JacksonObject;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Block extends JacksonObject {

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("blocked_user_id")
    private String blockedUserId;

    @JsonProperty("created_at")
    private Long createdAt;

}
