package com.example.model;


public class Departement {

	 private String id;
	    private String nom;

	    public Departement(String id, String nom) {
	        this.id = id;
	        this.nom = nom;
	    }

	    public String getId() { return id; }
	    public void setId(String id) { this.id = id; }

	    public String getNom() { return nom; }
	    public void setNom(String nom) { this.nom = nom; }
	    
}
