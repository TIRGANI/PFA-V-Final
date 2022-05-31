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
 //   @Autowired
 //   RoleRepository roleRepository;
  //  @Autowired
  //  UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
     //   userRepository.deleteAll();
      //roleRepository.deleteAll();
   //   Role admin = new Role("Administrateur");
   //   Role agre = new Role("Agreculteur");
     // roleRepository.save(admin);
     // roleRepository.save(agre);
     // userRepository.save(new User("tirgani","123","tirgani@gmail.com",admin));


    }
}
