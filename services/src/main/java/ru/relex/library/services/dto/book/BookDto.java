package ru.relex.library.services.dto.book;

import javax.validation.constraints.NotBlank;

import static ru.relex.library.services.constraint.ConstraintMessage.Constraint;
import static ru.relex.library.services.constraint.ConstraintMessage.Field;

public class BookDto {

  private Integer id;
  private String isbn;

  @NotBlank(message = Field.NAME + Constraint.IS_EMPTY)
  private String name;

  private String genre;

  @NotBlank(message = Field.AUTHOR + Constraint.IS_EMPTY)
  private String author;

  private String year;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }
}
