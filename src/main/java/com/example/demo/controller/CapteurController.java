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

import com.example.demo.model.Capteur;
import com.example.demo.repository.CapteurRepository;

@RestController
@RequestMapping("capteur")
public class CapteurController {
	@Autowired
	private CapteurRepository capteurRepository;

	@GetMapping("/all")
	public List<Capteur> findAll() {
		return capteurRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<Capteur> findByCode(@PathVariable final int id) {
		return capteurRepository.findById(id);
	}
	@PostMapping(value = "/save")
	public void save(@RequestBody final Capteur capteur) {
		capteurRepository.save(capteur);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(required = true) int id) {
		capteurRepository.deleteById(id);
	}
}
