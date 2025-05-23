package com.ohgiraffers.pattern.chap03.behavioral.section04.iterator;

/**
 * 설명. 이터레이터 패턴에서 순회할 요소 클래스
 *  - 도서 정보를 나타내는 클래스
 */
public class Book {
    private String title;
    private String author;
    private String genre;
    private int publishYear;

    public Book(String title, String author, String genre, int publishYear) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publishYear = publishYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", publishYear=" + publishYear +
                '}';
    }
}
