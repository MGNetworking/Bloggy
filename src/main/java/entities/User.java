package entities;

import java.time.LocalDateTime;
import java.util.*;

public class User {

    private Long id;
    private String nom;                     // nom de famille
    private String prenom;
    private String surnom;                  // nom utiliser sur le site
    private String password;
    private String email;
    private String tentative;               // tentive de connection

    private String cooki;

    List<RoleUser> listeRole = new ArrayList<>(5);

    public User() {
    }

    public User(String nom, String password) {
        this.nom = nom;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSurnom() {
        return surnom;
    }

    public void setSurnom(String surnom) {
        this.surnom = surnom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTentative() {
        return tentative;
    }

    public void setTentative(String tentative) {
        this.tentative = tentative;
    }

    public List<RoleUser> getListeRole() {
        return listeRole;
    }

    public void setListeRole(List<RoleUser> listeRole) {
        this.listeRole = listeRole;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", surnom='" + surnom + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", tentative='" + tentative + '\'' +
                ", listeRole=" + listeRole +
                '}';
    }
}
