package com.example.demo.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GetUserWithHTTPServletRequestController {
    @Autowired
    UserRepository userRepository;
    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserNameSimple(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        return principal.getName();
    }
    @GetMapping()
    @RequestMapping(value = "/role", method = RequestMethod.GET)
    @ResponseBody
    public String currentRole(HttpServletRequest request) {

        Principal principal = request.getUserPrincipal();
        for (User u :userRepository.findAll()) {
            if (u.getUsername().equals(principal.getName()))
            {
                return u.getRole().getNome()+"";
            }
        }
        return null;


    }
    @RequestMapping(value = "/userid", method = RequestMethod.GET)
    @ResponseBody
    public String currentId(HttpServletRequest request) {

        Principal principal = request.getUserPrincipal();
        for (User u :userRepository.findAll()) {
            if (u.getUsername().equals(principal.getName()))
            {
                return u.getUserId()+"";
            }
        }
        return null;


    }


}