package com.sda.vendingmachine.implementation;

import com.sda.vendingmachine.bank.Coin;
import com.sda.vendingmachine.storage.Item;

import java.math.BigDecimal;
import java.util.Queue;

public interface IVendingMachine {

    Item getITem(int productCode); //int productCode inseamna codul produsului, tasta 22, etc

    void payITem(int productCode, Queue<Coin> amountPayed);

    void getChange(BigDecimal amountExpected, BigDecimal amountReceived);

    void cancelRequest();
}
