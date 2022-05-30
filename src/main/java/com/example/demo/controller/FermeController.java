package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.*;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.FermeRepository;
import com.example.demo.repository.GrandeurRepository;
import com.example.demo.repository.ParcelleRepository;

@RestController
@RequestMapping("ferme")
public class FermeController {
	@Autowired
	private FermeRepository fermeRepository;
	@Autowired
	private GrandeurRepository grandeurRepository;
	@Autowired
	private ParcelleRepository parcelleRepository;
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/all")
	public List<Ferme> findAll() {
		return fermeRepository.findAll();
	}

	@GetMapping("/alltemp")
	public List<TempFerm> findtempferm() {
		List<TempFerm> list = new ArrayList<>();
		for (Ferme ferm : fermeRepository.findAll()) {

			for (Parcelle parcelle : parcelleRepository.findAll()) {

				for (Grandeur grandeur : grandeurRepository.findAll()) {
					if (ferm.getId() == parcelle.getFerme().getId()
							&& grandeur.getParcelle().getId() == parcelle.getId() && grandeur.getType().equals("temperature")) {

						list.add(new TempFerm(ferm.getId(), grandeur.getValeur(), grandeur.getDate()));
					}
				}
			}
		}
		return list;
	}

	@GetMapping(value = "/{id}")
	public Optional<Ferme> findByCode(@PathVariable final int id) {
		return fermeRepository.findById(id);
	}
	@GetMapping(value = "/count")
	public int count() {
		int i=0;
		for (Ferme f : fermeRepository.findAll()) {
			++i;
		}
		return i;
	}

	@PostMapping(value = "/save")
	public void save(@RequestBody final Ferme ferme) {
		fermeRepository.save(ferme);
	}
	@PostMapping(value = "/saves")
	public void saves(@RequestBody final Ferme ferme) {
		User user = new User();
		for (User u: userRepository.findAll()) {
			if (u.getUserId()==ferme.getUser().getUserId())
			{
				user = u;
			}
		}
		ferme.setUser(user);
		fermeRepository.save(ferme);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(required = true) int id) {
		fermeRepository.deleteById(id);
	}
}
