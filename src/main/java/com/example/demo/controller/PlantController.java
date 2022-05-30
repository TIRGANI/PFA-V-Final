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

import com.example.demo.model.Ferme;
import com.example.demo.model.Parcelle;
import com.example.demo.model.Plante;
import com.example.demo.model.TypePlante;
import com.example.demo.model.TypeSole;
import com.example.demo.repository.PlanteRepository;
import com.example.demo.repository.TypePlanteRepository;

@RestController
@RequestMapping("plante")
public class PlantController {
	@Autowired
	private PlanteRepository planteRepository;
	@Autowired
	private TypePlanteRepository typeeplanteRepository;

	@GetMapping("/all")
	public List<Plante> findAll() {
		return planteRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<Plante> findByCode(@PathVariable final int id) {
		return planteRepository.findById(id);
	}
	@GetMapping(value = "/count")
	public int count() {
		int i=0;
		for (Plante f : planteRepository.findAll()) {
			++i;
		}
		return i;
	}
	@PostMapping(value = "/save")
	public void save(@RequestBody final Plante plante) {
		planteRepository.save(plante);
	}
	// add new parcelle 
		@PostMapping(value = "/saves")
		public void saves(@RequestBody Plante plante) {
			TypePlante tp = new TypePlante();
			for (TypePlante t : typeeplanteRepository.findAll()) {
				if (t.getId() == plante.getTypePlante().getId()) {
					tp = t;
				}
			}
			
			Plante p = new Plante(plante.getLibelle(),plante.getRacine(), plante.getPhoto(),tp);
			planteRepository.save(p);

		}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(required = true) int id) {
		planteRepository.deleteById(id);
	}
}
