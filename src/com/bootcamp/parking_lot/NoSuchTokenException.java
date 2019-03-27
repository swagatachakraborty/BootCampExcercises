package com.bootcamp.parking_lot;

class NoSuchTokenException extends RuntimeException{
    NoSuchTokenException() {
        super("Invalid Token");
    }
}
