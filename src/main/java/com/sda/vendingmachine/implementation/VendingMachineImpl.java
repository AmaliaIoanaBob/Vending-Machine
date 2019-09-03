package com.sda.vendingmachine.implementation;

import com.sda.vendingmachine.bank.Bank;
import com.sda.vendingmachine.bank.Coin;
import com.sda.vendingmachine.exceptions.SoldOutException;
import com.sda.vendingmachine.storage.Item;
import com.sda.vendingmachine.storage.VendingStorage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.util.Map;
import java.util.Queue;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class VendingMachineImpl implements IVendingMachine {
    private VendingStorage storage;
    private Bank bank;

    public Item getItem(int productCode) {
        //accesam storage map cu GET

        Map<Integer, Queue<Item>> storageMap = storage.getStorageMap();

        //din map obtinem coada de la cheia cu valoarea product code
        Queue<Item> queueByProductCode = storageMap.get(productCode);

        if (queueByProductCode == null || queueByProductCode.size() == 0) {
            throw new SoldOutException("Product is not available!");
        } else {
            return queueByProductCode.poll();

        }
    }

    public void payItem(int productCode, Queue<Coin> amountPayed) {

    }

    public void getChange(BigDecimal amountExpected, BigDecimal amountReceived) {

    }

    public void cancelRequest() {

    }
}
