package ru.relex.library.services.dto.user;

import ru.relex.commons.model.Role;
import javax.validation.constraints.NotNull;

import static ru.relex.library.services.constraint.ConstraintMessage.Constraint;
import static ru.relex.library.services.constraint.ConstraintMessage.Field;

public class UserUpdateDto {

  private Integer id;
  private PersonalInfoDto personalInfo;

  public Integer getId() {
    return id;
  }

  public void setId(final Integer id) {
    this.id = id;
  }

  public PersonalInfoDto getPersonalInfo() {
    return personalInfo;
  }

  public void setPersonalInfo(final PersonalInfoDto personalInfo) {
    this.personalInfo = personalInfo;
  }
}
