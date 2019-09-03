package com.sda.vendingmachine.bank;

import lombok.Data;

import java.util.Queue;

@Data
public class Bank {
    private Queue<Coin> pennyStack;
    private Queue<Coin> nickelStack;
    private Queue<Coin> dimeStack;
    private Queue<Coin> halfStack;
    private Queue<Coin> quarterStack;
    private Queue<Coin> oneDollarStack;

    @Override
    public String toString() {
        return "The bank has: " + oneDollarStack.size() + " X 1$   "
                + halfStack.size() + " X 0.5$   "
                + quarterStack.size() + " X 0.25$   "
                + dimeStack.size() + " X 0.1$   "
                + nickelStack.size() + " X 0.05$   "
                + pennyStack.size() + " X 0.01$   ";
    }
}
