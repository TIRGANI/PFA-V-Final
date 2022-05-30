package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "typePlante")
public class TypePlante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String libelle;
	private Float humiditeMax;
	private Float humiditeMin;
	private Float temperatureMin;
	private Float temperatureMax;
	private Float luminosite;
	private Float besoinDeau;
	private String etat;

	public Float getBesoinDeau() {
		return besoinDeau;
	}

	public void setBesoinDeau(Float besoinDeau) {
		this.besoinDeau = besoinDeau;
	}

	public TypePlante() {

	}

	public TypePlante(int id) {
		this.id = id;
	}

	public TypePlante(int id, String libelle, Float humiditeMax, Float humiditeMin, Float temperatureMin,
			Float temperatureMax, Float luminosite, String etat) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.humiditeMax = humiditeMax;
		this.humiditeMin = humiditeMin;
		this.temperatureMax = temperatureMax;
		this.temperatureMin = temperatureMin;
		this.luminosite = luminosite;
		this.etat = etat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Float getHumiditeMax() {
		return humiditeMax;
	}

	public void setHumiditeMax(Float humiditeMax) {
		this.humiditeMax = humiditeMax;
	}

	public Float getHumiditeMin() {
		return humiditeMin;
	}

	public void setHumiditeMin(Float humiditeMin) {
		this.humiditeMin = humiditeMin;
	}

	public Float getTemperatureMin() {
		return temperatureMin;
	}

	public void setTemperatureMin(Float temperatureMin) {
		this.temperatureMin = temperatureMin;
	}

	public Float getTemperatureMax() {
		return temperatureMax;
	}

	public void setTemperatureMax(Float temperatureMax) {
		this.temperatureMax = temperatureMax;
	}

	public Float getLuminosite() {
		return luminosite;
	}

	public void setLuminosite(Float luminosite) {
		this.luminosite = luminosite;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

}
