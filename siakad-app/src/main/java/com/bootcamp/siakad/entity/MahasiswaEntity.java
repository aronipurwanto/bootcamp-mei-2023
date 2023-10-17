package com.bootcamp.siakad.entity;

import com.bootcamp.siakad.model.MahasiswaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity(name = "tbl_mahasiswa")
public class MahasiswaEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "jk", length = 36)
    private String jk;

    @Column(name = "alamat", length = 200)
    private String alamat;

    @Column(name = "tmpLahir", length = 100)
    private String tmpLahir;

    @Column(name = "tglLahir")
    private LocalDate tglLahir;

    @Column(name = "agama", length = 36)
    private String agama;

    @Column(name = "jurusan_id", length = 36)
    private Long jurusanId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "jurusan_id", insertable = false, updatable = false )
    private JurusanEntity jurusan;

    @OneToMany(mappedBy = "mahasiswa")
    private List<KelasDetailEntity> kelasDetail;

    public MahasiswaEntity(MahasiswaModel model) {
        BeanUtils.copyProperties(model, this);
    }
}
