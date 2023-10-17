package com.bootcamp.siakad.entity;

import com.bootcamp.siakad.model.RuangModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_ruang")
public class RuangEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="code_ruang", unique = true)
    private String code;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "gedung_id", nullable = false)
    private Long gedungId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gedung_id", insertable = false, updatable = false)
    private GedungEntity gedung;

    public RuangEntity(RuangModel model) {
        this.code = model.getCode();
        this.name = model.getName();
        this.gedungId = model.getGedungId();
    }
}
