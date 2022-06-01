package com.example.demo.model;

import com.example.demo.repository.*;
import jdk.internal.org.objectweb.asm.tree.FrameNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Component
public class TestName implements CommandLineRunner {
    @Autowired
    GrandeurRepository grandeurRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ParcelleRepository parcelleRepository;
    @Override
    public void run(String... args) throws Exception {
      //  userRepository.deleteAll();
        Parcelle parcelle1 = new Parcelle();
        for (Parcelle parcelle: parcelleRepository.findAll()) {
            if (parcelle.getId()==1)
            {
        parcelle1=parcelle;
            }

        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("PST"));
        Date date = simpleDateFormat.parse("01/05/2022");
        grandeurRepository.save(new Grandeur("temperature", (float) 22,date,parcelle1));
        Date date1 = simpleDateFormat.parse("02/05/2022");
        grandeurRepository.save(new Grandeur("temperature", (float) 30,date1,parcelle1));
        Date date2 = simpleDateFormat.parse("03/05/2022");
        grandeurRepository.save(new Grandeur("temperature", (float) 37,date2,parcelle1));
        Date date3 = simpleDateFormat.parse("04/05/2022");
        grandeurRepository.save(new Grandeur("temperature", (float) 10,date3,parcelle1));
        Date date4 = simpleDateFormat.parse("05/05/2022");
        grandeurRepository.save(new Grandeur("temperature", (float) 5,date4,parcelle1));
        Date date5 = simpleDateFormat.parse("06/05/2022");
        grandeurRepository.save(new Grandeur("temperature", (float) 10,date5,parcelle1));


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
