package entities;

public class RoleUser {

    private String role;

    public RoleUser() {
    }

    public RoleUser(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return this.role;
    }
}
