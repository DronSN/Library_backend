package ru.relex.library.services.dto.booksmoving;

import ru.relex.library.services.constraint.ConstraintMessage;
import ru.relex.library.services.dto.book.PaperBookDto;
import ru.relex.library.services.dto.user.UserDto;
import ru.relex.library.services.validator.PaperBookPresent;
import ru.relex.library.services.validator.UserPresent;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.Instant;

public class BookHistoryDto {
    private int id;
    @Positive(message = ConstraintMessage.Field.PAPER_BOOK_ID + ConstraintMessage.Constraint.NOT_POSITIVE)
    @PaperBookPresent
    private int PaperBookId;

    @Positive(message = ConstraintMessage.Field.USER_ID + ConstraintMessage.Constraint.NOT_POSITIVE)
    @UserPresent
    private int UserId;
    private PaperBookDto paperBook;
    private UserDto user;

    @NotBlank(message = ConstraintMessage.Field.STATUS + ConstraintMessage.Constraint.IS_EMPTY)
    private String status;
    private Instant createdAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPaperBookId() {
        return PaperBookId;
    }

    public void setPaperBookId(int paperBookId) {
        PaperBookId = paperBookId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public PaperBookDto getPaperBook() {
        return paperBook;
    }

    public void setPaperBook(PaperBookDto paperBook) {
        this.paperBook = paperBook;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
