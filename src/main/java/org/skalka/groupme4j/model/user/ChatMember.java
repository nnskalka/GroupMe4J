package org.skalka.groupme4j.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.skalka.groupme4j.model.JacksonObject;

@Data
@EqualsAndHashCode(callSuper = true)
public class ChatMember extends JacksonObject {
    
    @JsonProperty("avatar_url")
    public String avatarUrl;
    
    @JsonProperty("id")
    public String id;
    
    @JsonProperty("name")
    public String name;
    
}
