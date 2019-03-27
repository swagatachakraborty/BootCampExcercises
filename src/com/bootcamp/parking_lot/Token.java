package com.bootcamp.parking_lot;

class Token {
    private static Integer latestId = 0;
    private Integer id;

    Token() {
        this.id = createToken();
    }

    private static Integer createToken() {
        return latestId++;
    }
}
