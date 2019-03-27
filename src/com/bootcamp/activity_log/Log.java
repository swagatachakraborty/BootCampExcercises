package com.bootcamp.activity_log;

import java.util.Objects;

class Log {
    private StringBuilder event;

    Log(String event) {
        this.event = new StringBuilder(event);
    }

    Log(String event, long time) {
        this.event = new StringBuilder(event).append(" ").append(time);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log) o;
        return Objects.equals(event, log.event);
    }

    String getLog() {
        return this.event.toString();
    }
}
