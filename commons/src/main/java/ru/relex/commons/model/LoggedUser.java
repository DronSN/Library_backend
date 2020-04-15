package ru.relex.commons.model;

public class LoggedUser {
    Role  role;
    private String username;

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
