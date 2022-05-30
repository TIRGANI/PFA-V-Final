package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.*;
import com.example.demo.repository.AffectationRepository;

@RestController
@RequestMapping("affectation")
public class AffectationController {
	@Autowired
	private AffectationRepository affectationRepository;

	@GetMapping("/all")
	public List<Affectation> findAll() {
		return affectationRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<Affectation> findByCode(@PathVariable final int id) {
		return affectationRepository.findById(id);
	}
	
	@PostMapping(value = "/save")
	public void save(@RequestBody final Affectation affectation) {
		affectationRepository.save(affectation);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(required = true) int id) {
		affectationRepository.deleteById(id);
	}
}
