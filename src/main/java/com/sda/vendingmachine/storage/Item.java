package com.sda.vendingmachine.storage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal; //bigdecimal e pt numere reale

@Data //genereaza gettere si settere
@AllArgsConstructor //genereaza constructor pentru parametrii
@NoArgsConstructor //e pentru constructorul default

public class Item {
    private int id;
    private String name;
    private BigDecimal price;
}
