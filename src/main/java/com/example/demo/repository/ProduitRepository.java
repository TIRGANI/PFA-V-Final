package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.model.Produit;


@Component
public interface ProduitRepository extends JpaRepository<Produit, Long> {
       
	Produit findByNom(String nom);

	Produit findById(long id);
	
	

}
