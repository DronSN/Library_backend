package ru.relex.commons.model;

public class LoggedUser implements CurrentUser{
    private int id;
    private Role  role;
    private String username;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LoggedUser(Role role, String username) {
        this.role = role;
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
