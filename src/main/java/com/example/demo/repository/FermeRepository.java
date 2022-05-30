package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.Ferme;

public interface FermeRepository extends JpaRepository<Ferme, Integer>{

}
