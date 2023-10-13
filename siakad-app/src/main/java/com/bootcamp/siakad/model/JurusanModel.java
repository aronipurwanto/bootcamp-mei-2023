package com.bootcamp.siakad.model;

import com.bootcamp.siakad.entity.FakultasEntity;
import com.bootcamp.siakad.entity.JurusanEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JurusanModel {
    private Long id;
    private String code;
    private String name;
    private Long fakultasId;
    private String fakultasName;

    public JurusanModel(JurusanEntity entity) {
        BeanUtils.copyProperties(entity, this);

        if(entity.getFakultas() != null){
            this.fakultasId = entity.getFakultasId();
            this.fakultasName = entity.getFakultas().getName();
        }
    }
}
