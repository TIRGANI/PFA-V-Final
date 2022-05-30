package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Branche;
import com.example.demo.repository.BracheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("branch")
public class BranchController {
	@Autowired
	private BracheRepository bracheRepository;

	@GetMapping("/all")
	public List<Branche> findAll() {
		return bracheRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<Branche> findByCode(@PathVariable final int id) {
		return bracheRepository.findById(id);
	}
	@PostMapping(value = "/save")
	public void save(@RequestBody final Branche branch) {
		bracheRepository.save(branch);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(required = true) int id) {
		bracheRepository.deleteById(id);
	}
}
