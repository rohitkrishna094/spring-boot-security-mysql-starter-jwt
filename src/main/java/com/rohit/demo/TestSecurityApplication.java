package com.rohit.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rohit.demo.model.Role;
import com.rohit.demo.model.RoleName;
import com.rohit.demo.repository.RoleRepository;

@SpringBootApplication
public class TestSecurityApplication implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(TestSecurityApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.count() <= 0) {
            Role rAdmin = new Role(RoleName.ROLE_ADMIN);
            Role rUser = new Role(RoleName.ROLE_USER);
            Role rPm = new Role(RoleName.ROLE_PM);
            roleRepository.save(rAdmin);
            roleRepository.save(rPm);
            roleRepository.save(rUser);

        }
    }

}
