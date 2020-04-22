package ru.relex.library.services.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.relex.library.db.model.User;
import ru.relex.library.services.dto.user.UserDto;
import ru.relex.library.services.dto.user.UserUpdateDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserUpdateStruct {

  @Mapping(target = "personalInfo.firstName", source = "firstName")
  @Mapping(target = "personalInfo.lastName", source = "lastName")
  @Mapping(target = "personalInfo.middleName", source = "middleName")
  UserUpdateDto toDto(User user);

  @Mapping(target = "firstName", source = "personalInfo.firstName")
  @Mapping(target = "lastName", source = "personalInfo.lastName")
  @Mapping(target = "middleName", source = "personalInfo.middleName")
  User fromDto(UserUpdateDto userDto);

  List<UserUpdateDto> toDto(List<User> users);

  List<User> fromDto(List<UserUpdateDto> userDtos);
}
