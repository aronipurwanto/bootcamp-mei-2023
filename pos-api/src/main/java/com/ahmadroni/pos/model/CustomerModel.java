package com.ahmadroni.pos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerModel {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
}
