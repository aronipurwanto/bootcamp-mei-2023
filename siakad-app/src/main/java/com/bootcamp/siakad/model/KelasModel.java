package com.bootcamp.siakad.model;

import com.bootcamp.siakad.entity.KelasEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KelasModel {
    private Long id;
    private String code;
    private String namaHari;
    @DateTimeFormat(pattern = "HH:mm")
    private Date jamMulai;
    @DateTimeFormat(pattern = "HH:mm")
    private Date jamSelesai;
    private String status;
    private String semester;
    private Integer tahunAjaran;
    private Integer kuota;
    private Boolean bisaOnline;

    private Long ruangId;
    private String ruangName;

    private Long dosenId;
    private String dosenName;

    private Long matakuliahId;
    private String matakuliahName;

    public KelasModel(KelasEntity entity) {
        BeanUtils.copyProperties(entity, this);
        if (entity.getRuang() != null){
            ruangId = entity.getRuang().getId();
            ruangName = entity.getRuang().getName();
        }

        if (entity.getDosen() != null){
            dosenId = entity.getDosen().getId();
            dosenName = entity.getDosen().getName();
        }

        if (entity.getMatakuliah() != null){
            matakuliahId = entity.getMatakuliah().getId();
            matakuliahName = entity.getMatakuliah().getName();
        }
    }
}
