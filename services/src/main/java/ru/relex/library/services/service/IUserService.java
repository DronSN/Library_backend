package ru.relex.library.services.service;

import ru.relex.commons.model.AuthenticatedUser;
import ru.relex.library.services.dto.user.UserDto;
import ru.relex.library.services.dto.user.UserUpdateDto;

import javax.validation.Valid;
import java.util.List;

public interface IUserService {

  List<UserDto> findUsers(String search);

  UserDto create(@Valid UserDto userDto);

  UserUpdateDto update(@Valid UserUpdateDto userDto);

  UserDto findById(int id);

  void remove(int userId);

  boolean isValidUsername(String username);

  UserDto createRegularUser(@Valid UserDto userDto);

  AuthenticatedUser getCurrentUser();

}
