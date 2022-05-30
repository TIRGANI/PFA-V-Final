package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Plante;
import com.example.demo.model.Role;
import com.example.demo.model.TypePlante;
import com.example.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("users")
public class userController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/save")
    public void save(@RequestBody User user) {
        userRepository.save(user);
    }

    // add new parcelle
    @PostMapping(value = "/saves")
    public void saves(@RequestBody User user) {
        Role role = new Role();
        for (Role r : roleRepository.findAll()) {
            if (r.getId() == user.getRole().getId()) {
                role = r;
            }
        }
        user.setRole(role);

        userRepository.save(user);

    }

    @GetMapping("/all")
    public List<User> findAll() {
        return userRepository.findAll();
    }
    @GetMapping("/allforAdmin/{id}")
    public List<User> findAllAdmin(@PathVariable(required = true) int id) {
       List<User> users = new ArrayList<>();
        for (User user:userRepository.findAll()) {
            if (user.getUserId()!=id)
            {
                users.add(user);
            }
        }
        return users;
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable(required = true) int id) {
        userRepository.deleteById(id);
    }

}
