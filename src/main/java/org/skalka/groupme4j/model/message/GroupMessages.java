package org.skalka.groupme4j.model.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.skalka.groupme4j.model.JacksonObject;

@ToString
public class GroupMessages extends JacksonObject {

    @Getter @Setter
    @JsonProperty("count")
    private Integer count;
    
    @Getter @Setter
    @JsonProperty("messages")
    private List<GroupMessage> messages;

}
