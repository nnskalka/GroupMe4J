package org.skalka.groupme4j.model.message;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Event {
    @JsonProperty("type")
    private String type;

    @JsonProperty("data")
    private EventData data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public EventData getData() {
        return data;
    }

    public void setData(EventData data) {
        this.data = data;
    }
}