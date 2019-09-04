package com.sda.vendingmachine.implementation;

import com.sda.vendingmachine.bank.Bank;
import com.sda.vendingmachine.bank.Coin;
import com.sda.vendingmachine.exceptions.NotSufficientChangeException;
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
        Map<Integer, Queue<Item>> storageMap = storage.getStorageMap();
        Queue<Item> queueByProductCode = storageMap.get(productCode);
        BigDecimal amountExpected = queueByProductCode.peek().getPrice(); //ne-am uitat in queue sa vedem cat platim
        BigDecimal amountPaidAsBigDecimal = getTotalMoneyAsBigDecimal(amountPayed); //metoda apelata, apoi folosita ca variabila

        if (amountPaidAsBigDecimal.compareTo(amountExpected) < 0) {
            throw new NotSufficientChangeException("You didn't paid enough");
        } else {
            bank.updateBank(amountPayed);
        }
    }

    public void getChange(BigDecimal amountExpected, BigDecimal amountReceived) {

    }

    public void cancelRequest() {

    }

    private BigDecimal getTotalMoneyAsBigDecimal(Queue<Coin> money) {
        BigDecimal total = BigDecimal.ZERO;
        for (Coin m: money) {
            switch (m) {
                case ONE_DOLLAR:
                    //adunam la total
                    total = total.add(BigDecimal.valueOf(1));
                    break;
                case HALF:
                    total = total.add(BigDecimal.valueOf(0.5));
                    break;
                case DIME:
                    total = total.add(BigDecimal.valueOf(0.1));
                    break;
                case NICKEL:
                    total = total.add(BigDecimal.valueOf(0.05));
                    break;
                case PENNY:
                    total = total.add(BigDecimal.valueOf(0.01));
                    break;
                case QUARTER:
                    total = total.add(BigDecimal.valueOf(0.25));
                    break;
            }

        }
        return total;
    }

}
