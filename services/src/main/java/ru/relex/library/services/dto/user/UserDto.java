package ru.relex.library.services.dto.user;

import ru.relex.commons.model.Role;

public class UserDto {

  private Integer id;
  private String username;
  private String password;
  private Role role;

  private PersonalInfoDto personalInfo;

  public Integer getId() {
    return id;
  }

  public void setId(final Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(final String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(final Role role) {
    this.role = role;
  }

  public PersonalInfoDto getPersonalInfo() {
    return personalInfo;
  }

  public void setPersonalInfo(final PersonalInfoDto personalInfo) {
    this.personalInfo = personalInfo;
  }
}
