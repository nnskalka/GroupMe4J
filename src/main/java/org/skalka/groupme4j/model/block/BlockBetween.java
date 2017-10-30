package org.skalka.groupme4j.model.block;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.skalka.groupme4j.model.JacksonObject;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BlockBetween extends JacksonObject {

    @JsonProperty("between")
    private Boolean between;

}
