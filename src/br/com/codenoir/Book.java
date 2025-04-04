package br.com.codenoir;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Book {
    public static int idCounter = 0;
    private int id;
    private String title;
    private Author author;
    private boolean available;
    private LocalDate createdAt;
    private LocalDateTime updatedAt;

    public Book(String title, Author author) {
        this.id = ++idCounter;
        this.title = title;
        this.author = author;
        this.available = true;
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
