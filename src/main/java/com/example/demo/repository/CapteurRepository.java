package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Capteur;


public interface CapteurRepository extends JpaRepository<Capteur, Integer>{

}
