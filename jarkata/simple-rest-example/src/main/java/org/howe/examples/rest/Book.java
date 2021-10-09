package org.howe.examples.rest;

public class Book {

    private String genre;

    private String author;

    private String title;

    public Book(String genre, String author, String title) {
        this.genre = genre;
        this.author = author;
        this.title = title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
