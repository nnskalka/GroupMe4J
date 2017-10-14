package org.skalka.groupme4j.model.message.attachment;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class MentionsAttachment extends Attachment {

    @Getter @Setter
    @JsonProperty("loci")
    private List<List<Integer>> loci = null;
    
    @Getter @Setter
    @JsonProperty("user_ids")
    private List<String> userIds = null;
    
}
