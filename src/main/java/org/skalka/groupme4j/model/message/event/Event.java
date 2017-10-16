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
  @Type(value = CalendarCreatedEvent.class, name = Event.CALENDAR_CREATED),
  @Type(value = CalendarUpdatedEvent.class, name = Event.CALENDAR_UPDATED),
  @Type(value = CalendarUserGoingEvent.class, name = Event.CALENDAR_USER_GOING),
    
  @Type(value = BotDeleteEvent.class, name = Event.BOT_DELETE),
  @Type(value = BotAddEvent.class, name = Event.BOT_ADD),
  
  @Type(value = GroupNameChangeEvent.class, name = Event.GROUP_NAME_CHANGE),
  @Type(value = GroupTopicChangeEvent.class, name = Event.GROUP_TOPIC_CHANGE),
  
  @Type(value = MemberAddedEvent.class, name = Event.MEMBER_ADDED_GROUP),
  @Type(value = MemberExitedEvent.class, name = Event.MEMBER_EXITED_CHAT),
  @Type(value = MemberRemovedEvent.class, name = Event.MEMBER_REMOVED_GROUP)
})
public abstract class Event extends JacksonObject {
    
    public final static String CALENDAR_CREATED = "calendar.event.created";
    public final static String CALENDAR_UPDATED = "calendar.event.updated";
    public final static String CALENDAR_USER_GOING = "calendar.event.user.going";
    
    public final static String BOT_DELETE = "bot.del";
    public final static String BOT_ADD = "bot.add";

    public final static String GROUP_NAME_CHANGE = "group.name_change";
    public final static String GROUP_TOPIC_CHANGE = "group.topic_change";
    
    public final static String MEMBER_ADDED_GROUP = "membership.announce.added";
    public final static String MEMBER_EXITED_CHAT = "membership.notifications.exited";
    public final static String MEMBER_REMOVED_GROUP = "membership.notifications.removed";
    
    @Getter @Setter
    @JsonProperty("type")
    private String type;

}
