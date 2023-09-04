package com.bootcamp.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HandphoneDto {
    private Integer id;
    private String kode;
    private String name;
    private Integer ram;
    private String baterai;
    private Integer storage;
    private String layar;
    private String warna;
    private String dimesni;
    private Integer rilis;
    private Integer harga;
    private Integer stock;
}
