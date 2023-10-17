package com.bootcamp.siakad.model;

import com.bootcamp.siakad.entity.GedungEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GedungModel {
    private String id;
    private String code;
    private String name;
    private Integer jmlLantai;
    private List<RuangModel> ruangs = new ArrayList<>();
    public GedungModel(GedungEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }

}
