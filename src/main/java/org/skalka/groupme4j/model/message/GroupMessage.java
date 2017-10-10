package org.skalka.groupme4j.model.message;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class GroupMessage extends Message {
    
    @Getter @Setter
    @JsonProperty("group_id")
    private String groupId;
    
    @Getter @Setter
    @JsonProperty("image_url")
    private String imageUrl;
    
    @Getter @Setter
    @JsonProperty("nickname")
    private String nickname;
    
    @Getter @Setter
    @JsonProperty("system")
    private String system;
    
}
