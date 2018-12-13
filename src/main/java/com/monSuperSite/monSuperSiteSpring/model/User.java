package com.monSuperSite.monSuperSiteSpring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "eMail")
	private String eMail;
	
	private String motDePasseActuel;
	
	@Column(name = "motDePasse")
	private String motDePasse;

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String nom, String prenom, String eMail, String motDePasseActuel, String motDePasse) {
		this.nom = nom;
		this.prenom = prenom;
		this.eMail = eMail;
		this.motDePasseActuel = motDePasseActuel;
		this.motDePasse = motDePasse;
	}
	
	public User(String nom, String prenom, String eMail, String motDePasse) {
		this.nom = nom;
		this.prenom = prenom;
		this.eMail = eMail;
		this.motDePasse = motDePasse;
	}
	
	
	
	public long getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}
	
	public String getMotDePasseActuel() {
		return motDePasseActuel;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	

}
