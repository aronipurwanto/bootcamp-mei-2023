package com.bootcamp.springapi.model;

import lombok.Data;

@Data
public class Product {
    private int id;
    private String nama;
    private String keterangan;
    private int harga;
}