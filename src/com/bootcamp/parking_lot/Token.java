package com.bootcamp.parking_lot;

class Token {
    private static Integer latestId = 0;
    private final Integer ID;

    Token() {
        this.ID = createToken();
    }

    private static Integer createToken() {
        return latestId++;
    }
}
