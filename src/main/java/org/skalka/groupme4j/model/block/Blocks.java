package org.skalka.groupme4j.model.block;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.skalka.groupme4j.model.JacksonObject;

public class Blocks extends JacksonObject {

    @Getter @Setter
    @JsonProperty("blocks")
    private List<Block> blocks;
    
}
