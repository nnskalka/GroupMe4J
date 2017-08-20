package org.skalka.groupme4j.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.skalka.groupme4j.model.JacksonObject;

@Data
@EqualsAndHashCode(callSuper = true)
public class User extends JacksonObject {
  
  @JsonProperty(value = "created_at", required = true)
  private Integer createdAt;
  
  @JsonProperty(value = "email", required = true)
  private String email;
  
  @JsonProperty("facebook_connected")
  private Boolean facebookConnected;
  
  @JsonProperty(value = "id", required = true)
  private String id;
  
  @JsonProperty("image_url")
  private String imageUrl;
  
  @JsonProperty("locale")
  private String locale;
  
  @JsonProperty(value = "name", required = true)
  private String name;
  
  @JsonProperty(value = "phone_number", required = true)
  private String phoneNumber;
  
  @JsonProperty("sms")
  private Boolean sms;
  
  @JsonProperty("twitter_connected")
  private Boolean twitterConnected;
  
  @JsonProperty("updated_at")
  private Integer updatedAt;
  
  @JsonProperty(value = "user_id", required = true)
  private String userId;
  
  @JsonProperty("zip_code")
  private String zipCode;
  
  @JsonProperty("share_url")
  private String shareUrl;
  
  @JsonProperty("share_qr_code_url")
  private String shareQrCodeUrl;
  
}
