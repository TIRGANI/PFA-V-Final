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
import com.example.demo.model.Parcelle;
import com.example.demo.model.Plantage;
import com.example.demo.model.TypeSole;
import com.example.demo.repository.ParcelleRepository;
import com.example.demo.repository.PlantageRepository;
import com.example.demo.repository.PlanteRepository;

@RestController
@RequestMapping("plantage")
public class PlantageController {
	@Autowired
	private PlantageRepository plantageRepository;
	@Autowired
	private PlanteRepository planteRepository;
	@Autowired
	private ParcelleRepository parcelleRepository;

	@GetMapping("/all")
	public List<Plantage> findAll() {
		return plantageRepository.findAll();
	}
	// add new parcelle 
		@PostMapping(value = "/saves")
		public void saves(@RequestBody Plantage plantage) {
			Plante p = new Plante();
			Parcelle pa = new Parcelle();
			for (Plante pl : planteRepository.findAll()) {
				if (pl.getId() == plantage.getPlante().getId()) {
					p = pl;
				}
			}
			for (Parcelle t : parcelleRepository.findAll()) {
				if (t.getId() == plantage.getParcelle().getId()) {
					pa = t;
				}
			}
			Plantage pli = new Plantage(plantage.getString(),plantage.getNbrplante(),pa,p,plantage.getDateplantage());
			plantageRepository.save(pli);

		}

	
	@GetMapping(value = "/{id}")
	public Optional<Plantage> findByCode(@PathVariable final int id) {
		return plantageRepository.findById(id);
	}
	@PostMapping(value = "/save")
	public void save(@RequestBody final Plantage plantage) {
		plantageRepository.save(plantage);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(required = true) int id) {
		plantageRepository.deleteById(id);
	}

}
