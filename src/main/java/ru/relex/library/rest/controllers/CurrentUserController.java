package ru.relex.library.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.relex.commons.model.AuthenticatedUser;
import ru.relex.library.services.service.IUserService;

@RestController
@RequestMapping(
        path = "/api/currentuser",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class CurrentUserController {


    private final IUserService userService;

    @Autowired
    public CurrentUserController(final IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    AuthenticatedUser getUser() {
        return userService.getCurrentUser();
    }
}
