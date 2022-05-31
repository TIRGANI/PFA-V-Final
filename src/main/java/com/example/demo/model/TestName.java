package com.example.demo.model;

import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class TestName implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
            User user = new User();

            user.setRole(new Role("Administrateur"));
            user.setUsername("tirgani");
            user.setPassword("123");
            System.out.println("User-W"+user.getUsername());
            userRepository.save(user);

    }
}
