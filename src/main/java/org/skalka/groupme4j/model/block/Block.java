package org.skalka.groupme4j.model.block;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.skalka.groupme4j.model.JacksonObject;

public class Block extends JacksonObject {

    @Getter @Setter
    @JsonProperty("user_id")
    private String userId;
    
    @Getter @Setter
    @JsonProperty("blocked_user_id")
    private String blockedUserId;
    
    @Getter @Setter
    @JsonProperty("created_at")
    private Long createdAt;
    
}
