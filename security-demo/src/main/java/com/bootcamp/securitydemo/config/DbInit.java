package com.bootcamp.securitydemo.config;

import com.bootcamp.securitydemo.entity.ProductEntity;
import com.bootcamp.securitydemo.entity.RoleEntity;
import com.bootcamp.securitydemo.entity.UserEntity;
import com.bootcamp.securitydemo.repository.ProductRepo;
import com.bootcamp.securitydemo.repository.RoleRepo;
import com.bootcamp.securitydemo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class DbInit implements CommandLineRunner {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder encoder;
    private final ProductRepo productRepo;

    @Override
    public void run(String... args) throws Exception {
        initUserAndRole();

        initProduct();
    }

    private void initUserAndRole(){
        // insert role
        if(roleRepo.findAll().isEmpty()){
            try {
                this.roleRepo.saveAll(
                        Arrays.asList(
                                new RoleEntity(UUID.randomUUID().toString(), "ROLE_USER"),
                                new RoleEntity(UUID.randomUUID().toString(), "ROLE_ADMIN"),
                                new RoleEntity(UUID.randomUUID().toString(), "ROLE_SUPER_USER")
                        )
                );
                log.info("Save Role is success");
            }catch (Exception e){
                log.info("Save Role is failed, error: {}", e.getMessage());
            }
        }

        // insert user
        if(userRepo.findAll().isEmpty()){
            Optional<RoleEntity> suRole = roleRepo.findByName("ROLE_SUPER_USER");
            if(suRole.isPresent()){
                this.userRepo.save(new UserEntity(UUID.randomUUID().toString(), "Super User","super.user@gmail.com",
                        encoder.encode("P@ssW0rd"), Arrays.asList(suRole.get()))
                );
            }

            Optional<RoleEntity> userRole = roleRepo.findByName("ROLE_USER");
            userRole.ifPresent(roleEntity -> this.userRepo.save(new UserEntity(UUID.randomUUID().toString(), "User", "user@gmail.com",
                    encoder.encode("P@ssW0rd"), Arrays.asList(roleEntity))
            ));

            Optional<RoleEntity> adminRole = roleRepo.findByName("ROLE_ADMIN");
            adminRole.ifPresent(roleEntity -> this.userRepo.save(new UserEntity(UUID.randomUUID().toString(), "Admin", "admin@gmail.com",
                    encoder.encode("P@ssW0rd"), Arrays.asList(roleEntity))
            ));
        }
    }

    private void initProduct(){
        if(productRepo.findAll().isEmpty()){
            this.productRepo.saveAll(Arrays.asList(
                    new ProductEntity(UUID.randomUUID().toString(),"P001","Susu Cair",18000.0,100.0),
                    new ProductEntity(UUID.randomUUID().toString(),"P002","Susu Coklate",20000.0,100.0),
                    new ProductEntity(UUID.randomUUID().toString(),"P003","Susu Strobery",25000.0,100.0),
                    new ProductEntity(UUID.randomUUID().toString(),"P004","Susu Vanila",30000.0,100.0)
                    )
            );
        }
    }
}
