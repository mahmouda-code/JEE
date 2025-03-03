package com.example.model;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/departements")

public class DepartementController {
	 private static GestionDonnees gestion = GestionDonnees.getInstance();

	    
	    @POST
	    @Path("/ajouter")
	    @Consumes(MediaType.APPLICATION_JSON)
	    public void ajouterDepartement(Departement departement) {
	        gestion.ajouterDepartement(departement);
	    }

	    @PUT
	    @Path("/modifier/{id}")
	    @Consumes(MediaType.APPLICATION_JSON)
	    public void modifierDepartement(@PathParam("id") int id, @QueryParam("nom") String nouveauNom) {
	        gestion.modifierDepartement(id, nouveauNom);
	    }

	    @DELETE
	    @Path("/supprimer/{id}")
	    public void supprimerDepartement(@PathParam("id") int id) {
	        gestion.supprimerDepartement(id);
	    }

	    @GET
	    @Path("/liste")
	    @Produces(MediaType.APPLICATION_JSON)
	    public List<Departement> getDepartements() {
	        return gestion.getDepartements();
	    }

	    @GET
	    @Path("/{id}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Departement getDepartementById(@PathParam("id") int id) {
	        return gestion.getDepartementById(id);
	    }
	}

