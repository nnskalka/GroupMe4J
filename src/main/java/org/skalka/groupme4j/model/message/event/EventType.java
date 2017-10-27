package org.skalka.groupme4j.model.message.event;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum EventType {
    
    @JsonProperty(EventType.BOT_ADDED)
    BotAdded,
    
    @JsonProperty(EventType.BOT_DELETED)
    BotDeleted,
    
    
    @JsonProperty(EventType.CALENDAR_CREATED)
    CalendarCreated,
    
    @JsonProperty(EventType.CALENDAR_UPDATED)
    CalendarUpdated,
    
    @JsonProperty(EventType.CALENDAR_USER_DECLINED)
    CalendarUserDeclined,
    
    @JsonProperty(EventType.CALENDAR_USER_GOING)
    CalendarUserGoing,
    
    @JsonProperty(EventType.CALENDAR_USER_UNDECIDED)
    CalendarUserUndecided,

    
    @JsonProperty(EventType.MEMBER_ADDED_GROUP)
    MemberAddedGroup,
    
    @JsonProperty(EventType.MEMBER_ADDED_GROUP)
    MemberExitedGroup,
    
    @JsonProperty(EventType.MEMBER_REMOVED_GROUP)
    MemberRemovedGroup,
    
    
    @JsonProperty(EventType.GROUP_NAME_CHANGE)
    GroupNameChanged,
    
    @JsonProperty(EventType.GROUP_TOPIC_CHANGE)
    GroupTopicChanged;
    
    
    public static final String BOT_ADDED = "bot.add";
    public static final String BOT_DELETED = "bot.del";
    
    public static final String CALENDAR_CREATED = "calendar.event.created";
    public static final String CALENDAR_UPDATED = "calendar.event.updated";
    public static final String CALENDAR_USER_DECLINED = "calendar.event.user.not_going";
    public static final String CALENDAR_USER_GOING = "calendar.event.user.going";
    public static final String CALENDAR_USER_UNDECIDED = "calendar.event.user.undecided";
    
    public static final String MEMBER_ADDED_GROUP = "membership.announce.added";
    public static final String MEMBER_EXITED_CHAT = "membership.notifications.exited";
    public static final String MEMBER_REMOVED_GROUP = "membership.notifications.removed";
    
    public static final String GROUP_NAME_CHANGE = "group.name_change";
    public static final String GROUP_TOPIC_CHANGE = "group.topic_change";
    
}
