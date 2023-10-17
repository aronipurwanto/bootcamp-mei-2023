package com.bootcamp.siakad.entity;

import com.bootcamp.siakad.model.KelasModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_kelas")
public class KelasEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code",length = 20, unique = true)
    private String code;

    @Column(name = "namaHari")
    private String namaHari;

    @Temporal(TemporalType.TIME)
    @Column(name = "jamMulai")
    private Date jamMulai;

    @Temporal(TemporalType.TIME)
    @Column(name = "jamSelesai")
    private Date jamSelesai;

    @Column(name = "ruang_id", nullable = false)
    private Long ruangId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ruang_id", insertable = false, updatable = false)
    private RuangEntity ruang;

    @Column(name = "dosen_id", nullable = false)
    private Long dosenId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dosen_id", insertable = false, updatable = false)
    private DosenEntity dosen;

    @Column(name = "matakuliah_id", nullable = false)
    private Long matakuliahId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "matakuliah_id", insertable = false, updatable = false)
    private MatakuliahEntity matakuliah;

    @Column(name = "status")
    private String status;

    @Column(name = "semester")
    private String semester;

    @Column(name = "tahunAjaran")
    private Integer tahunAjaran;

    @Column(name = "kuota")
    private Integer kuota;

    @Column(name = "bisaOnline")
    private Boolean bisaOnline;

    @OneToMany(mappedBy = "kelas", fetch = FetchType.EAGER)
    private List<KelasDetailEntity> kelasDetail;

    public KelasEntity(KelasModel model) {
        BeanUtils.copyProperties(model, this);
    }
}
