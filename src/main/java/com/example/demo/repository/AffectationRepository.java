package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Affectation;


public interface AffectationRepository extends JpaRepository<Affectation, Integer>{

}
