package org.skalka.groupme4j.model.message.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.skalka.groupme4j.model.JacksonObject;

@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME, 
  include = JsonTypeInfo.As.PROPERTY, 
  property = "type")
@JsonSubTypes({ 
  @Type(value = GroupNameChangeEvent.class, name = Event.GROUP_NAME_CHANGE)
})
public abstract class Event extends JacksonObject {

    public final static String GROUP_NAME_CHANGE = "group.name_change";
    
    @Getter @Setter
    @JsonProperty("type")
    private String type;

}
