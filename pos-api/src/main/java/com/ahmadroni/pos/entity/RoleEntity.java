package com.ahmadroni.pos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_role")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_sequence")
    @TableGenerator(name = "tbl_role_seq", table = "tbl_sequence", pkColumnName = "sequence_id", pkColumnValue = "sequence_value")
    @Column(name = "id")
    private Long id;

    @Column(name = "role_name", length = 32)
    private String name;
}
