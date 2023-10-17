package com.bootcamp.siakad.entity;

import com.bootcamp.siakad.model.MatakuliahModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_matakuliah")
public class MatakuliahEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "sks")
    private Integer sks;

    public MatakuliahEntity(MatakuliahModel model) {
        BeanUtils.copyProperties(model, this);
    }
}
