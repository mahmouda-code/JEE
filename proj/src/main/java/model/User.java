package model;

//public class User {
    //private String username;
   // private String hashedPassword;
   // private Role role; // ADMIN, MANAGER, EMPLOYEE

    // Constructeur + Getters/Setters


//}


//import java.io.Serializable;

//public class User implements Serializable {
	
  //  protected int id;
  //  protected String nom;
  //  protected String prenom;
  //  protected String email;
  //  protected String motDePasse;
  //  protected String role;
    
//}




public class User {
    private String username;
    private String passwordHash;
    private Role role;

    // Getters et Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}