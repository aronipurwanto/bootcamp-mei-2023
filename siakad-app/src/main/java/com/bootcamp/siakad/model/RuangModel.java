package com.bootcamp.siakad.model;

import com.bootcamp.siakad.entity.RuangEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RuangModel {
    private Long id;
    private String code;
    private String name;
    private Long gedungId;
    private String gedungName;

    public RuangModel(RuangEntity entity) {
        BeanUtils.copyProperties(entity, this);
        if (entity.getGedung() != null){
            gedungId = entity.getGedung().getId();
            gedungName = entity.getGedung().getName();
        }
    }
}
