package filter;

import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.Response;

@Provider
@Priority(1)
public class AccessFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext ctx) {
        // Logique de vérification du rôle via la session
        if (ctx.getUriInfo().getPath().contains("/admin") && !estAdmin(ctx)) {
            ctx.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }

    private boolean estAdmin(ContainerRequestContext ctx) {
        // Implémentez la vérification de la session ici
        return true; // Exemple simplifié
    }
}
