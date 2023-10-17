package com.bootcamp.siakad.entity;

import com.bootcamp.siakad.model.LookupModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lookup_tab")
public class LookupEntity {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "lookup_group", length = 64, nullable = false)
    private String groups;

    @Column(name = "lookup_code", length = 20, nullable = false)
    private String code;

    @Column(name = "lookup_name", length = 100, nullable = false)
    private String name;

    @Column(name = "lookup_position", nullable = false)
    private Integer position;

    public LookupEntity(String groups, String code, String name, Integer position) {
        this.groups = groups;
        this.code = code;
        this.name = name;
        this.position = position;
    }

    public LookupEntity(LookupModel model){
        BeanUtils.copyProperties(model, this);
    }
}
