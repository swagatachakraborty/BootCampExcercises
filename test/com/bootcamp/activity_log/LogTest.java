package com.bootcamp.activity_log;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LogTest {
    @Test
    void shouldStoreTheLogWithoutTime() {
        String without_time = "Without time";
        Log without_time_log = new Log(without_time);
        assertEquals(without_time, without_time_log.getLog());
    }

    @Test
    void shouldStoreTheLogWithTimeStamp() {
        String with_time = "With time";
        Log with_time_log = new Log(with_time, 1234);
        String expected = with_time + " 1234";
        assertEquals(expected, with_time_log.getLog());
    }
}
