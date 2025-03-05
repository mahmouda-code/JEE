package controller;

import model.Role;
import service.RoleService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/admin/roles")
public class RoleController {
    private RoleService roleService = new RoleService();

    @POST
    public Response ajouterRole(@QueryParam("nom") String nom) {
        roleService.ajouterRole(new Role(nom));
        return Response.ok("Rôle " + nom + " créé").build();
    }

    @DELETE
    @Path("/{nom}")
    public Response supprimerRole(@PathParam("nom") String nom) {
        roleService.supprimerRole(nom);
        return Response.ok("Rôle supprimé").build();
    }
}


