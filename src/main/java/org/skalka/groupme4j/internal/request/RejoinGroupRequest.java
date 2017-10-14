package org.skalka.groupme4j.internal.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class RejoinGroupRequest {

    @Getter @Setter
    @JsonProperty("group_id")
    private String groupId;

}
