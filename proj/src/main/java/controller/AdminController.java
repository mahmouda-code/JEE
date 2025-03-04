package controller;

import model.Employee;
import model.Departement;
import model.Role;
import service.EmployeService;
import service.DepartementService;
import service.RoleService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AdminController {
    private EmployeService employeService = new EmployeService();
    private DepartementService departementService = new DepartementService();
    private RoleService roleService = new RoleService();

    /*** GESTION DES EMPLOYÉS ***/
    @GET
    @Path("/employes")
    public Response getEmployes(@Context HttpServletRequest request) {
        if (!estAdmin(request)) return Response.status(Response.Status.UNAUTHORIZED).entity("Accès interdit").build();
        List<Employee> employes = employeService.getEmployes();
        return Response.ok(employes).build();
    }

    @POST
    @Path("/employes")
    public Response ajouterEmploye(Employee employe, @Context HttpServletRequest request) {
        if (!estAdmin(request)) return Response.status(Response.Status.UNAUTHORIZED).entity("Accès interdit").build();
        employeService.ajouterEmploye(employe);
        return Response.ok("Employé ajouté avec succès").build();
    }

    @PUT
    @Path("/employes/{email}")
    public Response modifierEmploye(@PathParam("email") String email, Employee employe, @Context HttpServletRequest request) {
        if (!estAdmin(request)) return Response.status(Response.Status.UNAUTHORIZED).entity("Accès interdit").build();
        boolean modifie = employeService.modifierEmploye(email, employe);
        return modifie ? Response.ok("Employé modifié avec succès").build() : Response.status(Response.Status.NOT_FOUND).entity("Employé introuvable").build();
    }

    @DELETE
    @Path("/employes/{email}")
    public Response supprimerEmploye(@PathParam("email") String email, @Context HttpServletRequest request) {
        if (!estAdmin(request)) return Response.status(Response.Status.UNAUTHORIZED).entity("Accès interdit").build();
        employeService.supprimerEmploye(email);
        return Response.ok("Employé supprimé avec succès").build();
    }

    /*** GESTION DES DÉPARTEMENTS ***/
    @GET
    @Path("/departements")
    public Response getDepartements(@Context HttpServletRequest request) {
        if (!estAdmin(request)) return Response.status(Response.Status.UNAUTHORIZED).entity("Accès interdit").build();
        List<Departement> departements = departementService.getDepartements();
        return Response.ok(departements).build();
    }

    @POST
    @Path("/departements")
    public Response ajouterDepartement(@QueryParam("nom") String nom, @Context HttpServletRequest request) {
        if (!estAdmin(request)) return Response.status(Response.Status.UNAUTHORIZED).entity("Accès interdit").build();
        departementService.ajouterDepartement(nom);
        return Response.ok("Département ajouté avec succès").build();
    }

    @PUT
    @Path("/departements/{id}")
    public Response modifierDepartement(@PathParam("id") int id, @QueryParam("nom") String nouveauNom, @Context HttpServletRequest request) {
        if (!estAdmin(request)) return Response.status(Response.Status.UNAUTHORIZED).entity("Accès interdit").build();
        boolean modifie = departementService.modifierDepartement(id, nouveauNom);
        return modifie ? Response.ok("Département modifié avec succès").build() : Response.status(Response.Status.NOT_FOUND).entity("Département introuvable").build();
    }

    @DELETE
    @Path("/departements/{id}")
    public Response supprimerDepartement(@PathParam("id") int id, @Context HttpServletRequest request) {
        if (!estAdmin(request)) return Response.status(Response.Status.UNAUTHORIZED).entity("Accès interdit").build();
        boolean supprime = departementService.supprimerDepartement(id);
        return supprime ? Response.ok("Département supprimé avec succès").build() : Response.status(Response.Status.NOT_FOUND).entity("Département introuvable").build();
    }

    /*** GESTION DES RÔLES ***/
    @GET
    @Path("/roles")
    public Response getRoles(@Context HttpServletRequest request) {
        if (!estAdmin(request)) return Response.status(Response.Status.UNAUTHORIZED).entity("Accès interdit").build();
        return Response.ok(roleService.getRoles()).build();
    }

    @POST
    @Path("/roles")
    public Response ajouterRole(@QueryParam("role") String role, @Context HttpServletRequest request) {
        if (!estAdmin(request)) return Response.status(Response.Status.UNAUTHORIZED).entity("Accès interdit").build();
        roleService.ajouterRole(Role.valueOf(role.toUpperCase()));
        return Response.ok("Rôle ajouté avec succès").build();
    }

    @DELETE
    @Path("/roles")
    public Response supprimerRole(@QueryParam("role") String role, @Context HttpServletRequest request) {
        if (!estAdmin(request)) return Response.status(Response.Status.UNAUTHORIZED).entity("Accès interdit").build();
        roleService.supprimerRole(Role.valueOf(role.toUpperCase()));
        return Response.ok("Rôle supprimé avec succès").build();
    }

    /*** MÉTHODE PRIVÉE POUR VÉRIFIER LE RÔLE ADMIN ***/
    private boolean estAdmin(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Employee user = (session != null) ? (Employee) session.getAttribute("user") : null;
        return user != null && user.getRole() == Role.ADMIN;
    }
}
