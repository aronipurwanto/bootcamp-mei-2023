package com.bootcamp.siakad.entity;

import com.bootcamp.siakad.model.FakultasModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_fakultas")
public class FakultasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fakultas_code", length = 10, unique = true)
    private String code;

    @Column(name = "fakultas_name", length = 128)
    private String name;

    public FakultasEntity(FakultasModel model) {
        this.code = model.getCode();
        this.name = model.getName();
    }
}
