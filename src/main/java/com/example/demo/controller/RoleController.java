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

import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;

@RestController
@RequestMapping("roles")
public class RoleController {
	@Autowired
	private RoleRepository roleRepository;

	@GetMapping("/all")
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<Role> findByCode(@PathVariable final int id) {
		return roleRepository.findById(id);
	}
	@PostMapping(value = "/save")
	public void save(@RequestBody final Role role) {
		roleRepository.save(role);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(required = true) int id) {
		roleRepository.deleteById(id);
	}
}
