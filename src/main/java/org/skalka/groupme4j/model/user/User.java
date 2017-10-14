package org.skalka.groupme4j.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.skalka.groupme4j.model.JacksonObject;

public class User extends JacksonObject {
    
    @Getter @Setter
    @JsonProperty("created_at")
    private Integer createdAt;
    
    @Getter @Setter
    @JsonProperty("email")
    private String email;
    
    @Getter @Setter
    @JsonProperty("facebook_connected")
    private Boolean facebookConnected;
    
    @Getter @Setter
    @JsonProperty("id")
    private String id;
    
    @Getter @Setter
    @JsonProperty("image_url")
    private String imageUrl;
    
    @Getter @Setter
    @JsonProperty("locale")
    private String locale;
    
    @Getter @Setter
    @JsonProperty("name")
    private String name;
    
    @Getter @Setter
    @JsonProperty("phone_number")
    private String phoneNumber;
    
    @Getter @Setter
    @JsonProperty("sms")
    private Boolean sms;
    
    @Getter @Setter
    @JsonProperty("twitter_connected")
    private Boolean twitterConnected;
    
    @Getter @Setter
    @JsonProperty("updated_at")
    private Integer updatedAt;
    
    @Getter @Setter
    @JsonProperty("user_id")
    private String userId;
    
    @Getter @Setter
    @JsonProperty("zip_code")
    private String zipCode;
    
    @Getter @Setter
    @JsonProperty("share_url")
    private String shareUrl;
    
    @Getter @Setter
    @JsonProperty("share_qr_code_url")
    private String shareQrCodeUrl;
    
}
