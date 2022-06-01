package com.example.demo.model;

import com.example.demo.repository.*;
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

        Date date1 = simpleDateFormat.parse("02/05/2022");

        Date date2 = simpleDateFormat.parse("03/05/2022");

        Date date3 = simpleDateFormat.parse("04/05/2022");

        Date date4 = simpleDateFormat.parse("05/05/2022");

        Date date5 = simpleDateFormat.parse("06/05/2022");
        Grandeur g1 = new Grandeur("temperature", (float) 22,date,parcelle1);
        g1.setType("temperature");
        g1.setValeur((float) 23);
        g1.setDate(date);
        g1.setParcelle(parcelle1);
        Grandeur g2 = new Grandeur();
        g2.setType("temperature");
        g2.setDate(date1);
        g2.setParcelle(parcelle1);
        Grandeur g3 = new Grandeur();
        g3.setType("temperature");
        g3.setValeur((float) 37);
        g3.setDate(date2);
        g3.setParcelle(parcelle1);
        Grandeur g4 = new Grandeur();
        g4.setType("temperature");
        g4.setValeur((float) 10);
        g4.setDate(date3);
        g4.setParcelle(parcelle1);
        Grandeur g5 = new Grandeur();
        g5.setType("temperature");
        g5.setValeur((float) 32);
        g5.setDate(date4);
        g5.setParcelle(parcelle1);
        grandeurRepository.save(g1);
        grandeurRepository.save(g2);
        grandeurRepository.save(g3);
        grandeurRepository.save(g4);
        grandeurRepository.save(g5);


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
