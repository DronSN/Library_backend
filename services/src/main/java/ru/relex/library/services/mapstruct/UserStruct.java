package ru.relex.library.services.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.relex.library.db.model.User;
import ru.relex.library.services.dto.user.UserDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserStruct {

  @Mapping(target = "personalInfo.firstName", source = "firstName")
  @Mapping(target = "personalInfo.lastName", source = "lastName")
  @Mapping(target = "personalInfo.middleName", source = "middleName")
  @Mapping(target = "password", ignore = true)
  UserDto toDto(User user);

  @Mapping(target = "firstName", source = "personalInfo.firstName")
  @Mapping(target = "lastName", source = "personalInfo.lastName")
  @Mapping(target = "middleName", source = "personalInfo.middleName")
  User fromDto(UserDto userDto);

  List<UserDto> toDto(List<User> users);

  List<User> fromDto(List<UserDto> userDtos);
}
