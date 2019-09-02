package com.sda.vendingmachine.exceptions;

public class SoldOutException extends RuntimeException {
    public SoldOutException(String message) { //implementarea exceptiei, constructor si optiunea cu message
        super(message);
    }
}
