package controller;


import model.Employee;
import model.Role;
import service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/auth")  
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthController {
    private AuthService authService = new AuthService();

    @POST
    @Path("/login")
    public Response login(Employee credentials, @Context HttpServletRequest request) {
        Employee employe = authService.authenticate(credentials.getEmail(), credentials.getMotDePasse());

        if (employe != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", employe);
            return Response.ok(employe).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Identifiants invalides").build();
        }
    }

    @POST
    @Path("/logout")
    public Response logout(@Context HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return Response.ok("Déconnexion réussie").build();
    }

    @GET
    @Path("/user/{email}")
    public Response getUtilisateur(@PathParam("email") String email, @Context HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Employee admin = (session != null) ? (Employee) session.getAttribute("user") : null;

        if (admin == null || admin.getRole() != Role.ADMIN) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Accès interdit").build();
        }

        Employee employe = authService.getUtilisateur(email);
        return (employe != null) ? Response.ok(employe).build() : Response.status(Response.Status.NOT_FOUND).entity("Utilisateur introuvable").build();
    }

    @DELETE
    @Path("/user/{email}")
    public Response supprimerUtilisateur(@PathParam("email") String email, @Context HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Employee admin = (session != null) ? (Employee) session.getAttribute("user") : null;

        if (admin == null || admin.getRole() != Role.ADMIN) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Accès interdit").build();
        }

        authService.supprimerUtilisateur(email);
        return Response.ok("Utilisateur supprimé avec succès").build();
    }
}


