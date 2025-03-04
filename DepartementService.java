package com.example.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.HashMap;
import java.util.Map;

import com.example.model.Departement;

@Path("/departements")
@Produces("application/json")
public class DepartementService {
    
	 private static Map<String, Departement> departements = new HashMap<>();

	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public Map<String, Departement> getDepartements() {
	        return departements;
	    }

	    @POST
	    @Path("/ajout")
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    public String addDepartement(Departement departement) {
	        if (departements.containsKey(departement.getId())) {
	            return "{\"message\":\"Erreur : un département avec cet ID existe déjà.\"}";
	        }

	        departements.put(String.valueOf(departement.getId()), departement); // ✅ Conversion en String
	        return "{\"message\":\"Département ajouté avec succès!\"}";
	    }

	    @PUT
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Response modifier(Departement departement) {
	        if (departement.getId() != null && !departement.getId().isEmpty()) {
	            if (departements.containsKey(departement.getId())) {
	                departements.put(departement.getId(), departement); // Mettre à jour le département
	                return Response.status(Response.Status.OK)
	                        .entity("{\"message\":\"Département modifié avec succès!\"}")
	                        .build();
	            } else {
	                return Response.status(Response.Status.NOT_FOUND)
	                        .entity("{\"message\":\"Erreur : L'ID du département n'est pas retrouvé.\"}")
	                        .build();
	            }
	        } else {
	            return Response.status(Response.Status.BAD_REQUEST)
	                    .entity("{\"message\":\"Erreur : L'ID ne peut pas être null ou vide.\"}")
	                    .build();
	        }
	    }

	    @DELETE 
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Response supprimer(Departement departement) {
	        if (departement.getId() != null && !departement.getId().isEmpty()) {
	            if (departements.containsKey(departement.getId())) {
	                departements.remove(departement.getId());
	                return Response.status(Response.Status.OK)
	                        .entity("{\"message\":\"Département supprimé avec succès!\"}")
	                        .build();
	            } else {
	                return Response.status(Response.Status.NOT_FOUND)
	                        .entity("{\"message\":\"Erreur : L'ID du département n'est pas retrouvé.\"}")
	                        .build();
	            }
	        } else {
	            return Response.status(Response.Status.BAD_REQUEST)
	                    .entity("{\"message\":\"Erreur : L'ID ne peut pas être null ou vide.\"}")
	                    .build();
	        }
	    }
	}
