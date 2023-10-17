package com.bootcamp.siakad.model;

import com.bootcamp.siakad.entity.FakultasEntity;
import com.bootcamp.siakad.entity.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleModel {
    private Long id;
    private String name;

    public RoleModel(RoleEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
