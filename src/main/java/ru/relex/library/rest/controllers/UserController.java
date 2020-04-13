package ru.relex.library.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.library.services.dto.user.UserDto;
import ru.relex.library.services.service.IUserService;

import java.util.List;

@RestController
@RequestMapping(
        path = "/api/users",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(final IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    List<UserDto> getUsers(@RequestParam(name = "search", required = false) String search) {
        return userService.findUsers(search);
    }

    @GetMapping("/{id}")
    UserDto findById(@PathVariable("id") int id) {
        return userService.findById(id);
    }

    @PutMapping("/{id}")
    UserDto update(@PathVariable("id") int id, @RequestBody UserDto user) {
        user.setId(id);
        return userService.update(user);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    UserDto create(@RequestBody UserDto user) {
        return userService.create(user);
    }
}
