package com.bootcamp.siakad.entity;

import com.bootcamp.siakad.model.DosenModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_fakultas")
public class DosenEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nip", unique = true)
    private String nip;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "jk")
    private String jk;

    @Column(name = "alamat", length = 200)
    private String alamat;

    @Column(name = "gelar")
    private String gelar;

    @OneToMany(mappedBy = "dosen", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<KelasEntity> kelas;

    public DosenEntity(DosenModel model) {
        BeanUtils.copyProperties(model, this);
    }
}
