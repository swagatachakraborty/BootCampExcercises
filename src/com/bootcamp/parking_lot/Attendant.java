package com.bootcamp.parking_lot;

class Attendant implements Observer{
    private final static int increment = 1;
    private final static int decrement = -1;
    private Display display;

    Attendant() {
        this.display = Display.create();
    }

    @Override
    public void inform(String notification) {
        System.out.println(notification);
    }
}
