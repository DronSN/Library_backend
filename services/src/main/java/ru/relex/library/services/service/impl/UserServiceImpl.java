package ru.relex.library.services.service.impl;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.relex.library.db.mappers.UserMapper;
import ru.relex.library.services.dto.user.UserDto;
import ru.relex.library.services.mapstruct.UserStruct;
import ru.relex.library.services.service.IPasswordEncoderService;
import ru.relex.library.services.service.IUserService;

import java.util.List;

@Service
@Validated
public class UserServiceImpl implements IUserService {

  private final UserMapper userMapper;
  private final UserStruct userStruct;
  private final IPasswordEncoderService passwordEncoderService;

  @Autowired
  public UserServiceImpl(
          final UserMapper userMapper,
          final UserStruct userStruct,
          final IPasswordEncoderService passwordEncoderService) {
    this.userMapper = userMapper;
    this.userStruct = userStruct;
    this.passwordEncoderService = passwordEncoderService;
  }

  @Override
  public List<UserDto> findUsers(final String search) {
    var users = userMapper.getUsers(search);
    return userStruct.toDto(users);
  }

  @Override
  public UserDto create(@Valid final UserDto userDto) {
    var user = userStruct.fromDto(userDto);
    user.setPassword(passwordEncoderService.encode(user.getPassword()));
    userMapper.insert(user);
    return userStruct.toDto(user);
  }

  @Override
  public UserDto update(@Valid final UserDto userDto) {
    var user = userStruct.fromDto(userDto);
    userMapper.update(user);
    return userStruct.toDto(user);
  }

  @Override
  public void remove(final int userId) {
    userMapper.delete(userId);
  }
}
