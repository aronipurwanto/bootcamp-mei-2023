package com.bootcamp.springmvc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "handphone")
public class HandphoneEntity {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "kode", length = 20)
    private String kode;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "ram")
    private Integer ram;

    @Column(name = "baterai", length = 100)
    private String baterai;

    @Column(name = "storage")
    private Integer storage;

    @Column(name = "layar", length = 150)
    private String layar;

    @Column(name = "warna", length = 100)
    private String warna;

    @Column(name = "dimensi", length = 100)
    private String dimesni;

    @Column(name = "rilis")
    private Integer rilis;

    @Column(name = "harga")
    private Integer harga;

    @Column(name = "stock")
    private Integer stock;
}
