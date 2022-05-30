package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Alert;


public interface AlertRepository extends JpaRepository<Alert, Integer>{

}
