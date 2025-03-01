package model;

//public class User {
    //private String username;
   // private String hashedPassword;
   // private Role role; // ADMIN, MANAGER, EMPLOYEE

    // Constructeur + Getters/Setters


//}


import java.io.Serializable;

public class User implements Serializable {
	
    protected int id;
    protected String nom;
    protected String prenom;
    protected String email;
    protected String motDePasse;
    protected String role;
    
}