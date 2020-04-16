package ru.relex.commons.model;

public class AuthenticatedUser {

    private boolean authenticated;
    private LoggedUser info;

    public AuthenticatedUser(boolean authenticated, LoggedUser info) {
        this.authenticated = authenticated;
        this.info = info;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public LoggedUser getInfo() {
        return info;
    }

    public void setInfo(LoggedUser info) {
        this.info = info;
    }
}
