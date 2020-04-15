package ru.relex.library.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.relex.commons.model.CurrentUser;
import ru.relex.library.db.mappers.UserMapper;
import ru.relex.library.services.dto.user.UserDto;
import ru.relex.library.services.mapstruct.UserStruct;
import ru.relex.library.services.service.IPasswordEncoderService;
import ru.relex.library.services.service.IUserService;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class UserServiceImpl implements IUserService {

  private final UserMapper userMapper;
  private final UserStruct userStruct;
  private final IPasswordEncoderService passwordEncoderService;
  private final CurrentUser currentUser;

  @Autowired
  public UserServiceImpl(
          final UserMapper userMapper,
          final UserStruct userStruct,
          final IPasswordEncoderService passwordEncoderService,
          final CurrentUser currentUser) {
    this.userMapper = userMapper;
    this.userStruct = userStruct;
    this.passwordEncoderService = passwordEncoderService;
    this.currentUser = currentUser;
  }

  @Override
  public List<UserDto> findUsers(final String search) {
    System.out.println(currentUser.getUsername() + " requested list of roles.");
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
  public UserDto findById(int id) {
    var user = userMapper.findById(id);
    return userStruct.toDto(user);
  }

  @Override
  public void remove(final int userId) {
    userMapper.delete(userId);
  }
}
