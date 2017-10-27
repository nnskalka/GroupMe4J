package org.skalka.groupme4j.internal.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class AddMemberRequest {
    
    @Getter @Setter
    @JsonProperty("direct_message")
    private List<AddedMember> directMessage;
    
    @ToString
    public class AddedMember {
        
        @Getter @Setter
        @JsonProperty("nickname")
        private String nickname;
        
        @Getter @Setter
        @JsonProperty("user_id")
        private String userId;
        
        @Getter @Setter
        @JsonProperty("phone_number")
        private String phoneNumber;
        
        @Getter @Setter
        @JsonProperty("email")
        private String email;
        
        @Getter @Setter
        @JsonProperty("guid")
        private String guid;
        
    }
    
}
