package com.bootcamp.siakad.model;

import com.bootcamp.siakad.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private Long id;
    private String userName;
    private String password;
    private String email;

    public UserModel(UserEntity entity){
        BeanUtils.copyProperties(entity, this);
    }
}
