package com.bootcamp.siakad.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_user")
public class UserEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 64)
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "email", length = 64)
    private String email;

    @ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "tbl_user_role", joinColumns = @JoinColumn(name = "user_id",
            referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id",
            referencedColumnName = "id"))
    private List<RoleEntity> roles = new ArrayList<>();

}