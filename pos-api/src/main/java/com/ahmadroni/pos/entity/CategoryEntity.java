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
@Table(name = "tbl_category")
public class CategoryEntity {
    @Id
    @TableGenerator(name = "tbl_category_seq",
            table = "tbl_sequence",
            pkColumnName = "sequence_id",
            valueColumnName="sequence_value",
            pkColumnValue = "category_id",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_category_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "category_code", length = 16, unique = true)
    private String code;

    @Column(name = "category_name", length = 64)
    private String name;

    public CategoryEntity(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
