package ru.relex.library.services.dto.book;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static ru.relex.library.services.constraint.ConstraintMessage.Constraint;
import static ru.relex.library.services.constraint.ConstraintMessage.Field;

public class BookDto {

  private Integer id;

  @Size(max = 30)
  private String isbn;

  @NotBlank(message = Field.NAME + Constraint.IS_EMPTY)
  @Size(max = 100)
  private String name;

  @Size(max = 50)
  private String genre;

  @NotBlank(message = Field.AUTHOR + Constraint.IS_EMPTY)
  @Size(max = 50)
  private String author;

  @Size(max = 4)
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
