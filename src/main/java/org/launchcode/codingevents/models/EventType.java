package org.launchcode.codingevents.models;

public enum EventType {

    CONFERENCE("Conference"),
    CLASS("Class"),
    MEETUP("Meetup"),
    SEMINAR("Seminar"),
    SOCIAL("Social"),
    WORKSHOP("Workshop");

    private final String displayType;

    EventType(String displayType) {
        this.displayType = displayType;
    }

    public String getDisplayType() {
        return displayType;
    }
}


