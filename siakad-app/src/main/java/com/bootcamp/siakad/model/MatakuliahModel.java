package com.bootcamp.siakad.model;

import com.bootcamp.siakad.entity.MatakuliahEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatakuliahModel {
    private Long id;
    private String code;
    private String name;
    private Integer sks;

    public MatakuliahModel(MatakuliahEntity entity){
        BeanUtils.copyProperties(entity, this);
    }
}
