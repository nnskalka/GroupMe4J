package org.skalka.groupme4j.internal.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class UpdateUserRequest {

  @Getter @Setter
  @JsonProperty("avatar_url")
  private String avatarUrl;

  @Getter @Setter
  @JsonProperty("name")
  private String name;

  @Getter @Setter
  @JsonProperty("email")
  private String email;

  @Getter @Setter
  @JsonProperty("zip_code")
  private String zipCode;
  
}
