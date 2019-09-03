package com.sda.vendingmachine.storage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Queue;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class VendingStorage {
    Map<Integer, Queue<Item>> storageMap;

    @Override
    public String toString() {
        String toReturn = "";

        for(Map.Entry<Integer, Queue<Item>> entry: storageMap.entrySet()){
            toReturn += "Tasta: " + entry.getKey() + " " +
                    entry.getValue().element().toString() + " cantitate: " + entry.getValue().size() + "\n";
        }
        return toReturn;
    }
}
