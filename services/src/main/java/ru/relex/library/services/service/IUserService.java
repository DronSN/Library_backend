package ru.relex.library.services.service;

import ru.relex.library.services.dto.user.UserDto;

import javax.validation.Valid;
import java.util.List;

public interface IUserService {

  List<UserDto> findUsers(String search);

  UserDto create(@Valid UserDto userDto);

  UserDto update(@Valid UserDto userDto);

  UserDto findById(int id);

  void remove(int userId);

}
