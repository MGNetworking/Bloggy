package entities;

import java.util.ArrayList;
import java.util.List;

public class User {

    private Long id;
    private String nom;
    private String password;

    List<Role> listeRole = new ArrayList();

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getListeRole() {
        return listeRole;
    }

    public void setListeRole(List<Role> listeRole) {
        this.listeRole = listeRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", password='" + password + '\'' +
                ", listeRole=" + listeRole +
                '}';
    }
}
