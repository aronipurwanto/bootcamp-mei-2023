package com.bootcamp.siakad.model;


import com.bootcamp.siakad.entity.DosenEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DosenModel {

    private String id;
    private String nip;
    private String name;
    private String jk;
    private String alamat;
    private String gelar;

    public DosenModel(DosenEntity entity){
        BeanUtils.copyProperties(entity, this);
    }
}
