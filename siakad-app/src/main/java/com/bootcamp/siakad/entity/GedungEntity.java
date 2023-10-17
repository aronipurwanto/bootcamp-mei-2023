package com.bootcamp.siakad.entity;

import com.bootcamp.siakad.model.GedungModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_gedung")
public class GedungEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code_gedung",length = 20,unique = true)
    private String code;

    @Column(name = "name_gedung", length = 200)
    private String name;

    @Column(name = "jmlLantai")
    private Integer jmlLantai;

    @OneToMany(mappedBy = "gedung", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RuangEntity> ruangs = new ArrayList<>();

    public GedungEntity(GedungModel model) {
        BeanUtils.copyProperties(model, this);
    }
}
