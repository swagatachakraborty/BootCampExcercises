package com.bootcamp.activity_log;

import java.util.ArrayList;
import java.util.List;

class ActivityLog {
    private List<String> logs;

    ActivityLog() {
        this.logs = new ArrayList<>();
    }

    List<String> add(String log) {
        this.logs.add(log);
        System.out.println("Log Added Successfully.");
        return this.logs;
    }
}
