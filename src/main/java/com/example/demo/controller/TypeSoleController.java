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

import com.example.demo.model.TypeSole;
import com.example.demo.repository.TYpeSoleRepository;

@RestController
@RequestMapping("typesole")
public class TypeSoleController {
	@Autowired
	private TYpeSoleRepository tYpeSoleRepository;

	@GetMapping("/all")
	public List<TypeSole> findAll() {
		return tYpeSoleRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<TypeSole> findByCode(@PathVariable final int id) {
		return tYpeSoleRepository.findById(id);
	}
	@PostMapping(value = "/save")
	public void save(@RequestBody final TypeSole typeSole) {
		tYpeSoleRepository.save(typeSole);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(required = true) int id) {
		tYpeSoleRepository.deleteById(id);
	}
}
