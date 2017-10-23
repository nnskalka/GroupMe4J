package org.skalka.groupme4j.model.block;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.skalka.groupme4j.model.JacksonObject;

public class BlockBetween extends JacksonObject {
    
    @Getter @Setter
    @JsonProperty("between")
    private Boolean between;
    
}
