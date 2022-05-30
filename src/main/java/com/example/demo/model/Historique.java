package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "historique")
public class Historique {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String StringArosage;
	private int qttEau;
	
	
	public Historique() {
		
	}
	public Historique(int id, String StringArosage, int qttEau) {
		super();
		this.id = id;
		this.StringArosage = StringArosage;
		this.qttEau = qttEau;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStringArosage() {
		return StringArosage;
	}
	public void setStringArosage(String StringArosage) {
		this.StringArosage = StringArosage;
	}
	public int getQttEau() {
		return qttEau;
	}
	public void setQttEau(int qttEau) {
		this.qttEau = qttEau;
	}
	

}
