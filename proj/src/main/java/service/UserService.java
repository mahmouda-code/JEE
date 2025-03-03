package service;



import model.User;
import model.Role;
import java.util.SecurityUtil;
import java.util.HashMap;
import java.util.Map;

public class UserService {
    private static final Map<String, User> users = new HashMap<>();
    private static UserService instance;

    private UserService() {
        // Initialisation de l'admin par défaut
        User admin = new User();
        admin.setUsername("admin");
        admin.setPasswordHash(SecurityUtil.hashPassword("admin"));
        admin.setRole(Role.ADMIN);
        users.put("admin", admin);
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public User authenticate(String username, String password) {
        User user = users.get(username);
        if (user != null && SecurityUtil.checkPassword(password, user.getPasswordHash())) {
            return user;
        }
        return null;
    }
}