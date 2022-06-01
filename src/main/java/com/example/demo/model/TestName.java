package com.example.demo.model;

import com.example.demo.repository.FermeRepository;
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
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    FermeRepository fermeRepository;
    @Override
    public void run(String... args) throws Exception {
      //  userRepository.deleteAll();

     /* Role admin = new Role("Administrateur");
      Role agre = new Role(2,"Agreculteur");

      User tirgani = new User();

      tirgani.setUsername("tirgani");
      tirgani.setPassword("123");
      tirgani.setEmail("tirgani.badreddine@gmail.com");
      tirgani.setRole(admin);
      userRepository.save(tirgani);*/
      //  Role agre = new Role("Agreculteur");
      //  roleRepository.save(agre);
    /*    User u = new User();
        for (User user: userRepository.findAll()) {
            if (user.getUsername().equals("tirgani"))
            {
            u=user;
            }
        }
        for (Ferme ferme: fermeRepository.findAll()) {
            if (!(ferme.getPhoto().equals("img/fermes/ticketing.png")))
            {
                fermeRepository.save(new Ferme(10,"img/fermes/ticketing.png",u));
            }

        }
*/

    }
}
