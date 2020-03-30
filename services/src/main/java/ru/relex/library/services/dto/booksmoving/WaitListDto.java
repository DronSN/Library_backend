package ru.relex.library.services.dto.booksmoving;

import ru.relex.library.services.constraint.ConstraintMessage;
import ru.relex.library.services.dto.book.BookDto;
import ru.relex.library.services.dto.user.UserDto;
import ru.relex.library.services.validator.BookPresent;
import ru.relex.library.services.validator.UserPresent;

import javax.validation.constraints.Positive;
import java.time.Instant;

public class WaitListDto {
    private int id;

    @Positive(message = ConstraintMessage.Field.BOOKS_ID + ConstraintMessage.Constraint.NOT_POSITIVE)
    @BookPresent
    private int booksId;

    @Positive(message = ConstraintMessage.Field.USER_ID + ConstraintMessage.Constraint.NOT_POSITIVE)
    @UserPresent
    private int UserId;

    private Instant createdAt;
    private BookDto bookDto;
    private UserDto userDto;

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
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public BookDto getBookDto() {
        return bookDto;
    }

    public void setBookDto(BookDto bookDto) {
        this.bookDto = bookDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
