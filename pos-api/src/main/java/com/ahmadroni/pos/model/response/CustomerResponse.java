package com.ahmadroni.pos.model.response;

import com.ahmadroni.pos.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    public CustomerResponse(CustomerEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
