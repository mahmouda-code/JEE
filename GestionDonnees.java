package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class GestionDonnees {
	  private static GestionDonnees instance;
	    private List<Departement> departements;

	    	    private GestionDonnees() {
	        departements = new ArrayList<>();

	        	        departements.add(new Departement(1, "Informatique"));
	        departements.add(new Departement(2, "Marketing"));
	    }

	    	    public static GestionDonnees getInstance() {
	        if (instance == null) {
	            instance = new GestionDonnees();
	        }
	        return instance;
	    }

	    public void ajouterDepartement(Departement departement) {
	        departements.add(departement);
	    }

	    public void modifierDepartement(int id, String nouveauNom) {
	        for (Departement dep : departements) {
	            if (dep.getId() == id) {
	                dep.setNom(nouveauNom);
	                break;
	            }
	        }
	    }

	    public void supprimerDepartement(int id) {
	        departements.removeIf(dep -> dep.getId() == id);
	    }

	    public List<Departement> getDepartements() {
	        return departements;
	    }

	    public Departement getDepartementById(int id) {
	        for (Departement dep : departements) {
	            if (dep.getId() == id) {
	                return dep;
	            }
	        }
	        return null;
	    }
	}

