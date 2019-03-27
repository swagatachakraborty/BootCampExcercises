package com.bootcamp.activity_log;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ActivityLogTest {
    @Test
    void shouldReturnAllTheLogsTillNow() {
        ActivityLog activityLog = new ActivityLog();
        String log = "First Activity";

        List<String> expected = new ArrayList<>();
        expected.add("First Activity");

        assertEquals(expected, activityLog.add(log));
    }
}
