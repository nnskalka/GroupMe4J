package org.skalka.groupme4j.request.group;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RejoinGroupRequest {
    @JsonProperty("group_id")
    private String groupId;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
