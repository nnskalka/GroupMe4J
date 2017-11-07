package org.skalka.groupme4j.model.poll;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.skalka.groupme4j.model.JacksonObject;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Poll extends JacksonObject {

    @JsonProperty("expiration")
    private Long expiration;
    
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("subject")
    private String subject;

}
