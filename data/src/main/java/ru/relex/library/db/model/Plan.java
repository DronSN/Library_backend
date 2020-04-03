package ru.relex.library.db.model;

import java.time.Instant;

public class Plan {
    private int id;
    private int userId;
    private int booksId;
    private int pageGoal;
    private Instant dateGoal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBooksId() {
        return booksId;
    }

    public void setBooksId(int booksId) {
        this.booksId = booksId;
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
