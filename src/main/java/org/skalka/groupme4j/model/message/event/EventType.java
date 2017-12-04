package org.skalka.groupme4j.model.message.event;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum EventType {
    
    @JsonProperty(EventType.BOT_ADDED)
    BotAdded,
    
    @JsonProperty(EventType.BOT_DELETED)
    BotDeleted,
    
    
    @JsonProperty(EventType.CALENDAR_CANCELLED)
    CalendarCancelled,
    
    @JsonProperty(EventType.CALENDAR_CREATED)
    CalendarCreated,
    
    @JsonProperty(EventType.CALENDAR_UPDATED)
    CalendarUpdated,
    
    @JsonProperty(EventType.CALENDAR_STARTED)
    CalendarStarted,
    
    @JsonProperty(EventType.CALENDAR_USER_DECLINED)
    CalendarUserDeclined,
    
    @JsonProperty(EventType.CALENDAR_USER_GOING)
    CalendarUserGoing,
    
    @JsonProperty(EventType.CALENDAR_USER_UNDECIDED)
    CalendarUserUndecided,
    
    
    @JsonProperty(EventType.GROUP_AVATAR_CHANGE)
    GroupAvatarChanged,
    
    @JsonProperty(EventType.GROUP_NAME_CHANGE)
    GroupNameChanged,
    
    @JsonProperty(EventType.GROUP_TOPIC_CHANGE)
    GroupTopicChanged,
    
    @JsonProperty(EventType.GROUP_TOPIC_REMOVED)
    GroupTopicRemoved,
    
    @JsonProperty(EventType.GROUP_TYPE_CHANGE)
    GroupTypeChanged,

    
    @JsonProperty(EventType.MEMBER_ADDED_GROUP)
    MemberAddedGroup,
    
    @JsonProperty(EventType.MEMBER_ADDED_GROUP)
    MemberExitedGroup,
    
    @JsonProperty(EventType.MEMBER_REJOINED_GROUP)
    MemberRejoinedGroup,
    
    @JsonProperty(EventType.MEMBER_REMOVED_GROUP)
    MemberRemovedGroup,
    
    
    @JsonProperty(EventType.POLL_CREATED)
    PollCreated,
    
    @JsonProperty(EventType.POLL_ENDED)
    PollEnded,
    
    @JsonProperty(EventType.POLL_REMINDER)
    PollReminder;
    
    
    public static final String BOT_ADDED = "bot.add";
    public static final String BOT_DELETED = "bot.del";
    
    public final static String CALENDAR_CANCELLED = "calendar.event.cancelled";
    public static final String CALENDAR_CREATED = "calendar.event.created";
    public static final String CALENDAR_UPDATED = "calendar.event.updated";
    public static final String CALENDAR_STARTED = "calendar.event.starting";
    public static final String CALENDAR_USER_DECLINED = "calendar.event.user.not_going";
    public static final String CALENDAR_USER_GOING = "calendar.event.user.going";
    public static final String CALENDAR_USER_UNDECIDED = "calendar.event.user.undecided";
    
    public static final String GROUP_AVATAR_CHANGE = "group.avatar_change";
    public static final String GROUP_NAME_CHANGE = "group.name_change";
    public static final String GROUP_TOPIC_CHANGE = "group.topic_change";
    public static final String GROUP_TOPIC_REMOVED = "group.topic_removed";
    public static final String GROUP_TYPE_CHANGE = "group.type_change";
    
    public static final String MEMBER_ADDED_GROUP = "membership.announce.added";
    public static final String MEMBER_EXITED_GROUP = "membership.notifications.exited";
    public static final String MEMBER_REJOINED_GROUP = "membership.announce.rejoined";
    public static final String MEMBER_REMOVED_GROUP = "membership.notifications.removed";
    
    public final static String POLL_CREATED = "poll.created";
    public final static String POLL_ENDED = "poll.finished";
    public final static String POLL_REMINDER = "poll.reminder";
    
}
