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
@Table(name = "tbl_customer")
public class CustomerEntity {
    @Id
    @TableGenerator(name = "tbl_customer_seq",
            table = "tbl_sequence",
            pkColumnName = "sequence_id",
            valueColumnName="sequence_value",
            pkColumnValue = "category_id",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_customer_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "customer_name", length = 64)
    private String name;

    @Column(name = "customer_email", length = 64)
    private String email;

    @Column(name = "customer_phone", length = 20)
    private String phone;

    @Column(name = "address", length = 120)
    private String address;

    public CustomerEntity(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
