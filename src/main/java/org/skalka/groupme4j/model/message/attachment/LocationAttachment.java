package org.skalka.groupme4j.model.message.attachment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class LocationAttachment extends Attachment {

    @Getter @Setter
    @JsonProperty("lat")
    private String latitude;

    @Getter @Setter
    @JsonProperty("lng")
    private String longitude;

    @Getter @Setter
    @JsonProperty("name")
    private String name;
    
    public LocationAttachment() {
        super();
        
        setType(Attachment.LOCATION_TYPE);
    }

}
