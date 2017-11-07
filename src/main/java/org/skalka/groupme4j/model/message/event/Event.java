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
  @Type(value = CalendarCancelledEvent.class, name = EventType.CALENDAR_CANCELLED),
  @Type(value = CalendarCreatedEvent.class, name = EventType.CALENDAR_CREATED),
  @Type(value = CalendarUpdatedEvent.class, name = EventType.CALENDAR_UPDATED),
  @Type(value = CalendarUserDeclinedEvent.class, name = EventType.CALENDAR_USER_DECLINED),
  @Type(value = CalendarUserGoingEvent.class, name = EventType.CALENDAR_USER_GOING),
  @Type(value = CalendarUserUndecidedEvent.class, name = EventType.CALENDAR_USER_UNDECIDED),
    
  @Type(value = BotDeleteEvent.class, name = EventType.BOT_DELETED),
  @Type(value = BotAddEvent.class, name = EventType.BOT_ADDED),
  
  @Type(value = GroupNameChangeEvent.class, name = EventType.GROUP_NAME_CHANGE),
  @Type(value = GroupTopicChangeEvent.class, name = EventType.GROUP_TOPIC_CHANGE),
  
  @Type(value = MemberAddedEvent.class, name = EventType.MEMBER_ADDED_GROUP),
  @Type(value = MemberExitedEvent.class, name = EventType.MEMBER_EXITED_CHAT),
  @Type(value = MemberRemovedEvent.class, name = EventType.MEMBER_REMOVED_GROUP),
  
  @Type(value = PollCreatedEvent.class, name = EventType.POLL_CREATED),
  @Type(value = PollEndedEvent.class, name = EventType.POLL_ENDED),
  @Type(value = PollReminderEvent.class, name = EventType.POLL_REMINDER)
})
public abstract class Event extends JacksonObject {
    
    @Getter @Setter
    @JsonProperty("type")
    private String type;

}
