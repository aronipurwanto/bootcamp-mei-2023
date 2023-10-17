package com.bootcamp.siakad.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_kelas_detail")
public class KelasDetailEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "kelas_id", nullable = false)
    private Long kelasId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kelas_id", insertable = false, updatable = false)
    private KelasEntity kelas;

    @Column(name = "mahasiswa_id", nullable = false)
    private Long mahasiswaId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mahasiswa_id", insertable = false, updatable = false)
    private MahasiswaEntity mahasiswa;

    @Column(name = "status", length = 20)
    private String status;
}
