package com.bootcamp.securitydemo.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDao {
    private final PasswordEncoder passwordEncoder;

    public List<UserDetails> getUserDetails(){
        return Arrays.asList(
                new User("admin@gmail.com",passwordEncoder.encode("password"), Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))),
                new User("user@gmail.com",passwordEncoder.encode("password"), Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")))
        );
    }

    public UserDetails findUserByEmail(String email){
        List<UserDetails> users = this.getUserDetails();

        return users.stream()
                .filter(u -> u.getUsername().equals(email))
                .findFirst()
                .orElseThrow(() ->new UsernameNotFoundException("User does not exist..!"));
    }
}
