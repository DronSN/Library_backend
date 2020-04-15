package ru.relex.library.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.relex.commons.model.CurrentUser;
import ru.relex.commons.model.LoggedUser;

@RestController
@RequestMapping(
        path = "/api/currentuser",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class CurrentUserController {


    private final CurrentUser currentUser;

    @Autowired
    public CurrentUserController(final CurrentUser currentUser, CurrentUser currentUser1) {
        this.currentUser = currentUser1;
    }

    @GetMapping
    LoggedUser getUser() {
        if (!(currentUser instanceof CurrentUser)){
            return null;
        } else {
            return new LoggedUser(currentUser.getRole(), currentUser.getUsername());
        }


    }

}
