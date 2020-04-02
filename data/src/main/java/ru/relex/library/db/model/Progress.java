package ru.relex.library.db.model;

import java.time.Instant;

public class Progress {
    private int id;
    private int userId;
    private int booksId;
    private int pageGot;
    private Instant createdAt;

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

    public int getPageGot() {
        return pageGot;
    }

    public void setPageGot(int pageGot) {
        this.pageGot = pageGot;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
