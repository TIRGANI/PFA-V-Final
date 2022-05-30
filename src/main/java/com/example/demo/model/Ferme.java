package com.example.demo.model;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="ferme")
public class Ferme {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private int nbrParcel;
	private String photo;
	@ManyToOne(cascade = CascadeType.PERSIST)
	
	private User user;
	
	
	public Ferme(int id, int numParcel, String img,User user) {
		super();
		this.id = id;
		this.nbrParcel = numParcel;
		this.photo = img;
		this.user =user;
	}
	
	public Ferme() {
		
	}
	
	public Ferme(int id) {
		this.id = id;
	} 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumParcel() {
		return nbrParcel;
	}
	public void setNumParcel(int numParcel) {
		this.nbrParcel = numParcel;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	 

}
