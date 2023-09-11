package com.bootcamp.securitydemo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String id;
    private String fullName;
    private String email;
    private String password;
    private String role;
}
