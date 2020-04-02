package ru.relex.library.services.dto.book;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import static ru.relex.library.services.constraint.ConstraintMessage.Constraint;
import static ru.relex.library.services.constraint.ConstraintMessage.Field;

public class ElectronicBookDto {
    private int id;

    @Positive(message = Field.BOOKS_ID + Constraint.NOT_POSITIVE)
    private int booksId;

    private BookDto bookDto;

    @NotBlank(message = Field.TYPE + Constraint.IS_EMPTY)
    @Size(max = 20,
            message = Field.TYPE + Constraint.TOO_LONG)
    private String type;

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

    /*
    @NotBlank(message = Field.FILE + Constraint.IS_EMPTY)
    @Size(max = 50,
            message = Field.FILE + Constraint.TOO_LONG) */
    private byte[] file;

    @NotBlank(message = Field.FILETYPE + Constraint.IS_EMPTY)
    @Size(max = 20,
            message = Field.FILETYPE + Constraint.TOO_LONG)
    private String fileType;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}