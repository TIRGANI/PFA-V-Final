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

import com.example.demo.model.Privilige;
import com.example.demo.repository.PriviligeRepository;

@RestController
@RequestMapping("privilige")
public class PriviligeController {
	@Autowired
	private PriviligeRepository priviligeRepository;

	@GetMapping("/all")
	public List<Privilige> findAll() {
		return priviligeRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<Privilige> findByCode(@PathVariable final int id) {
		return priviligeRepository.findById(id);
	}
	@PostMapping(value = "/save")
	public void save(@RequestBody final Privilige privilige) {
		priviligeRepository.save(privilige);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(required = true) int id) {
		priviligeRepository.deleteById(id);
	}
}
