package com.bootcamp.securitydemo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_role")
@Getter
@Setter
public class RoleEntity {
    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "role_name", length = 64, unique = true)
    private String name;
}
