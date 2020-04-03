package ru.relex.library.services.dto.user;

import ru.relex.library.services.constraint.ConstraintMessage;
import ru.relex.library.services.dto.book.BookDto;
import ru.relex.library.services.validator.BookPresent;
import ru.relex.library.services.validator.UserPresent;

import javax.validation.constraints.Future;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.time.Instant;

public class PlanDto {
    private int id;

    @Positive(message = ConstraintMessage.Field.BOOKS_ID + ConstraintMessage.Constraint.NOT_POSITIVE)
    @BookPresent
    private int booksId;

    @Positive(message = ConstraintMessage.Field.USER_ID + ConstraintMessage.Constraint.NOT_POSITIVE)
    @UserPresent
    private int userId;

    private UserDto userDto;
    private BookDto bookDto;

    @PositiveOrZero(message = ConstraintMessage.Field.PAGEGOAL + ConstraintMessage.Constraint.NOT_POSITIVE)
    private int pageGoal;

    @Future(message = ConstraintMessage.Field.DATAGOAL + ConstraintMessage.Constraint.NOT_FIT_FORMAT)
    private Instant dateGoal;

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

    public int getPageGoal() {
        return pageGoal;
    }

    public void setPageGoal(int pageGoal) {
        this.pageGoal = pageGoal;
    }

    public Instant getDateGoal() {
        return dateGoal;
    }

    public void setDateGoal(Instant dateGoal) {
        this.dateGoal = dateGoal;
    }
}
