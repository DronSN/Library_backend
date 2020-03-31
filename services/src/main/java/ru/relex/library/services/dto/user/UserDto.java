package ru.relex.library.services.dto.user;

import ru.relex.commons.model.Role;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static ru.relex.library.services.constraint.ConstraintMessage.Constraint;
import static ru.relex.library.services.constraint.ConstraintMessage.Field;

public class UserDto {

  private Integer id;

  @NotBlank(message = Field.USERNAME + Constraint.IS_EMPTY)
  @Size(max = 64,
        message = Field.USERNAME + Constraint.TOO_LONG)
  private String username;

  @Size(min = 8, message = Field.PASSWORD + Constraint.TOO_SHORT)
  @Size(max = 80,
        message = Field.PASSWORD + Constraint.TOO_LONG)
  private String password;

  @NotNull(message = Field.ROLE + Constraint.IS_NULL)
  private Role role;

  @Valid
  @NotNull(message = Field.PERSONAL_INFO + Constraint.IS_NULL)
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
