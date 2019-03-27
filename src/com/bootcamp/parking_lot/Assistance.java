package com.bootcamp.parking_lot;

class Assistance implements Observer{
    @Override
    public void inform(String notification) {
        System.out.println(notification);
    }
}
