package org.skalka.groupme4j.model.message;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EventData {

    @JsonProperty("event_name")
    private String eventName;

    @JsonProperty("minutes")
    private String minutes;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }
}
