package ru.relex.library.services.dto.user;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static ru.relex.library.services.constraint.ConstraintMessage.Constraint;
import static ru.relex.library.services.constraint.ConstraintMessage.Field;

public class PersonalInfoDto {

  @NotBlank(message = Field.FIRST_NAME + Constraint.IS_EMPTY)
  @Size(max = 50, message = Field.FIRST_NAME + Constraint.TOO_LONG)
  private String firstName;

  @NotBlank(message = Field.LAST_NAME + Constraint.IS_EMPTY)
  @Size(max = 50, message = Field.LAST_NAME + Constraint.TOO_LONG)
  private String lastName;

  @Size(max = 50, message = Field.MIDDLE_NAME + Constraint.TOO_LONG)
  private String middleName;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(final String middleName) {
    this.middleName = middleName;
  }
}
