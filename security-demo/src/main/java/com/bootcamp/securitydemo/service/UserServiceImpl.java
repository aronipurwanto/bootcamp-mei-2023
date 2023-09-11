package com.bootcamp.securitydemo.service;

import com.bootcamp.securitydemo.dto.UserDto;
import com.bootcamp.securitydemo.entity.RoleEntity;
import com.bootcamp.securitydemo.entity.UserEntity;
import com.bootcamp.securitydemo.repository.RoleRepo;
import com.bootcamp.securitydemo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserEntity> getAll() {
        return this.userRepo.findAll();
    }

    @Override
    public Optional<UserEntity> getById(String id) {
        return this.userRepo.findById(id);
    }

    @Override
    public Optional<UserEntity> save(UserDto request) {
        UserEntity entity = new UserEntity();
        BeanUtils.copyProperties(request, entity);
        // set new UUID
        entity.setId(UUID.randomUUID().toString());

        // get role
        Optional<RoleEntity> role = roleRepo.findByName(request.getRole());
        role.ifPresent(roleEntity -> entity.setRoles(Arrays.asList(roleEntity)));

        // set password to encrypt
        entity.setPassword(passwordEncoder.encode(request.getPassword()));

        try{
            this.userRepo.save(entity);
            log.info("Save user is success");
            return Optional.of(entity);
        }catch (Exception e){
            log.error("Save user is failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<UserEntity> update(String id, UserDto request) {
        if(id == null || id.isEmpty()){
            return Optional.empty();
        }

        // find user base on id
        UserEntity entity = this.userRepo.findById(id).orElse(null);
        if(entity == null){
            return Optional.empty();
        }

        // copy value property
        BeanUtils.copyProperties(request, entity);
        // get role
        Optional<RoleEntity> role = roleRepo.findByName(request.getRole());
        role.ifPresent(roleEntity -> entity.setRoles(Arrays.asList(roleEntity)));

        // set password to encrypt
        entity.setPassword(passwordEncoder.encode(request.getPassword()));

        try{
            this.userRepo.save(entity);
            log.info("Update user is success");
            return Optional.of(entity);
        }catch (Exception e){
            log.error("Update user is failed, error: {}", e.getMessage());
            return Optional.empty();
        }

    }

    @Override
    public Optional<UserEntity> delete(String id) {
        return Optional.empty();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepo.findByEmail(username)
                .orElseThrow(()->new UsernameNotFoundException("User Not found"));
    }
}
