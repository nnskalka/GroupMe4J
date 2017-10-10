package org.skalka.groupme4j.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.skalka.groupme4j.model.JacksonObject;

public class ChatMember extends JacksonObject {
    
    @Getter @Setter
    @JsonProperty("avatar_url")
    public String avatarUrl;
    
    @Getter @Setter
    @JsonProperty("id")
    public String id;
    
    @Getter @Setter
    @JsonProperty("name")
    public String name;
    
}
