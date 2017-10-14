package org.skalka.groupme4j.model.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.skalka.groupme4j.model.JacksonObject;

public class DirectMessages extends JacksonObject {

    @Getter @Setter
    @JsonProperty("count")
    private Integer count;
    
    @Getter @Setter
    @JsonProperty("direct_messages")
    private List<DirectMessage> directMessages = null;
    
    @Getter @Setter
    @JsonProperty("read_receipt")
    private ReadReceipt readReceipt;
    
}
