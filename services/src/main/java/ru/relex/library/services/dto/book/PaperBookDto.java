package ru.relex.library.services.dto.book;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import static ru.relex.library.services.constraint.ConstraintMessage.Constraint;
import static ru.relex.library.services.constraint.ConstraintMessage.Field;


public class PaperBookDto {

  private int id;

  @Positive(message = Field.BOOKS_ID + Constraint.NOT_POSITIVE)
  private int booksId;


  private BookDto bookDto;

  @Size(max = 50,
        message = Field.EDITION + Constraint.TOO_LONG)
  private String edition;

  @NotBlank(message = Field.FORMAT + Constraint.IS_EMPTY)
  @Size(max = 20,
        message = Field.FORMAT + Constraint.TOO_LONG)
  private String format;

  @Size(max = 4,
         message = Field.PUBLISHYEAR + Constraint.TOO_LONG)
  private String publishYear;

  @Size(max = 50,
        message = Field.PUBLISHER + Constraint.TOO_LONG)
  private String publisher;

  @PositiveOrZero(message = Field.TOTALAMOUNT + Constraint.NOT_POSITIVE)
   private int totalAmount;

  @PositiveOrZero(message = Field.FREEAMOUNT + Constraint.NOT_POSITIVE)
  private int freeAmount;

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

  public BookDto getBookDto() {
    return bookDto;
  }

  public void setBookDto(BookDto bookDto) {
    this.bookDto = bookDto;
  }

  public String getEdition() {
    return edition;
  }

  public void setEdition(String edition) {
    this.edition = edition;
  }

  public String getFormat() {
    return format;
  }

  public void setFormat(String format) {
    this.format = format;
  }

  public String getPublishYear() {
    return publishYear;
  }

  public void setPublishYear(String publishYear) {
    this.publishYear = publishYear;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public int getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(int totalAmount) {
    this.totalAmount = totalAmount;
  }

  public int getFreeAmount() {
    return freeAmount;
  }

  public void setFreeAmount(int freeAmount) {
    this.freeAmount = freeAmount;
  }
}
