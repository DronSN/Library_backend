package ru.relex.library.db.model;

import java.time.Instant;

public class BookHistory {
    private int id;
    private int PaperBookId;
    private int UserId;
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
}
