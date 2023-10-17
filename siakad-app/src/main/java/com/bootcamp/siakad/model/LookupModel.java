package com.bootcamp.siakad.model;

import com.bootcamp.siakad.entity.LookupEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LookupModel {
    private Long id;
    private String groups;
    private String code;
    private String name;
    private String position;
    private Boolean active;

    public LookupModel(LookupEntity entity){
        BeanUtils.copyProperties(entity, this);
    }
}
