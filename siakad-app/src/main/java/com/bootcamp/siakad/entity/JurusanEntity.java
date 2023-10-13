package com.bootcamp.siakad.entity;

import com.bootcamp.siakad.model.JurusanModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_jurusan")
public class JurusanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "jurusan_code", length = 10, unique = true)
    private String code;

    @Column(name = "jurusan_name", length = 128)
    private String name;

    @Column(name = "fakultas_id")
    private Long fakultasId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fakultas_id", insertable = false, updatable = false)
    private FakultasEntity fakultas;

    public JurusanEntity(JurusanModel model) {
        this.code = model.getCode();
        this.name = model.getName();
        this.fakultasId = model.getFakultasId();
    }
}
