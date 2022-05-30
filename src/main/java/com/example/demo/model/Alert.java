package com.example.demo.model;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "alert")
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Float humidite;
    private Float temperature;
    private Float luminosite;
    @Temporal(TemporalType.DATE)
    private Date date;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Boitier boitier;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Parcelle parcelle;

    public Alert() {

    }

    public Alert(int id, Float humidite, Float temperature, Float luminosite, Date date, Parcelle parcelle) {
        super();
        this.id = id;
        this.humidite = humidite;
        this.temperature = temperature;
        this.luminosite = luminosite;
        this.date = date;
        this.parcelle = parcelle;
    }

    public Alert(Float humidite, Float temperature, Float luminosite, Date date, Parcelle parcelle) {

        this.humidite = humidite;
        this.temperature = temperature;
        this.luminosite = luminosite;
        this.date = date;
        this.parcelle = parcelle;
    }

    public Parcelle getParcelle() {
        return parcelle;
    }

    public void setParcelle(Parcelle parcelle) {
        this.parcelle = parcelle;
    }

    public Date getDate() {
        return date;
    }


    public void setDate(Date date) {
        this.date = date;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Float getHumidite() {
        return humidite;
    }

    public void setHumidite(Float humidite) {
        this.humidite = humidite;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Float getLuminosite() {
        return luminosite;
    }

    public void setLuminosite(Float luminosite) {
        this.luminosite = luminosite;
    }


    public Boitier getBoitier() {
        return boitier;
    }


    public void setBoitier(Boitier boitier) {
        this.boitier = boitier;
    }

}
