package service;

import model.Employee;
import model.Role;
import java.util.HashMap;
import java.util.Map;

public class AuthService {
    private static Map<String, Employee> utilisateurs = new HashMap<>();

    static {
        // Admin par défaut avec identifiant "admin"
        utilisateurs.put("admin", new Employee(
            "admin", "admin", "Admin", "Super",
            "123456789", "Siège social", "0600000000", "Direction", "ADMIN"
        ));
    }

    // Méthodes existantes (authenticate, ajouterUtilisateur, etc.)...
}



//public class AuthService {
    // Stockage temporaire des utilisateurs (en mémoire)
  //  private static Map<String, User> users = new HashMap<>();

  //  static {
        // Admin par défaut (mot de passe haché avec BCrypt)
   //     users.put("admin", new User("admin", BCrypt.hashpw("admin", BCrypt.gensalt()), Role.ADMIN));
   // }

    // Vérifie les identifiants et retourne le rôle
  //  public static Role authenticate(String username, String password) {
   //     User user = users.get(username);
    //    if (user != null && BCrypt.checkpw(password, user.getHashedPassword())) {
     //       return user.getRole();
     //   }
     //   return null; // Échec de l'authentification
   // }
//}

