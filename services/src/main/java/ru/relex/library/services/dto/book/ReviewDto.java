package ru.relex.library.services.dto.book;

import ru.relex.library.services.constraint.ConstraintMessage;
import ru.relex.library.services.dto.user.UserDto;
import ru.relex.library.services.validator.BookPresent;
import ru.relex.library.services.validator.UserPresent;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.time.Instant;

public class ReviewDto {

  private int id;

  @Positive(message = ConstraintMessage.Field.BOOKS_ID + ConstraintMessage.Constraint.NOT_POSITIVE)
  @BookPresent
  private int booksId;

  @Positive(message = ConstraintMessage.Field.USER_ID + ConstraintMessage.Constraint.NOT_POSITIVE)
  @UserPresent
  private int userId;

  private UserDto userDto;
  private BookDto bookDto;

  @PositiveOrZero(message = ConstraintMessage.Field.RANK + ConstraintMessage.Constraint.NOT_POSITIVE)
  private int rank;

  @NotBlank(message = ConstraintMessage.Field.REVIEW + ConstraintMessage.Constraint.IS_EMPTY)
  @Size(max = 2000,
          message = ConstraintMessage.Field.REVIEW + ConstraintMessage.Constraint.TOO_LONG)
  private String review;

  private Instant createdAt;
  private Instant updatedAt;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getBooksId() {
    return booksId;
  }

  public void setBooksId(int booksId) {
    this.booksId = booksId;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public UserDto getUserDto() {
    return userDto;
  }

  public void setUserDto(UserDto userDto) {
    this.userDto = userDto;
  }

  public BookDto getBookDto() {
    return bookDto;
  }

  public void setBookDto(BookDto bookDto) {
    this.bookDto = bookDto;
  }

  public int getRank() {
    return rank;
  }

  public void setRank(int rank) {
    this.rank = rank;
  }

  public String getReview() {
    return review;
  }

  public void setReview(String review) {
    this.review = review;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
  }
}
