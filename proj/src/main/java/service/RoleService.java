package service;

import model.Role;
import java.util.HashMap;
import java.util.Map;

public class RoleService {
    private Map<String, Role> roles = new HashMap<>();

    public void ajouterRole(Role role) {
        roles.put(role.getNom().toUpperCase(), role);
    }

    public void supprimerRole(String roleNom) {
        roles.remove(roleNom.toUpperCase());
    }

    public Map<String, Role> getRoles() {
        return roles;
    }
}