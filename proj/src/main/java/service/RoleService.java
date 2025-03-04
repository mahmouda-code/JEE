package service;

import model.Role;
import java.util.ArrayList;
import java.util.List;

public class RoleService {
    private static List<Role> roles = new ArrayList<>();

    static {
        roles.add(Role.ADMIN);
        roles.add(Role.RESPONSABLE);
        roles.add(Role.EMPLOYE);
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void ajouterRole(Role role) {
        if (!roles.contains(role)) {
            roles.add(role);
        }
    }

    public void supprimerRole(Role role) {
        roles.remove(role);
    }
}
