package ru.relex.library.services.service;

import javax.validation.Valid;
import ru.relex.library.services.dto.user.UserDto;

import java.util.List;

public interface IUserService {

  List<UserDto> findUsers(String search);

  UserDto create(@Valid UserDto userDto);

  UserDto update(@Valid UserDto userDto);

  void remove(int userId);

}
