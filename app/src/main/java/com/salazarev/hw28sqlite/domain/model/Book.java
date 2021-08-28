package com.salazarev.hw28sqlite.domain.model;

public class Book {

    public final long bookId;
    public final String uuid;
    public final String title;
    public final String author;
    public final int shelfNumber;
    public final int pageCount;

    public Book(long bookId, String uuid, String title, String author, int shelfNumber, int pageCount) {
        this.bookId = bookId;
        this.uuid = uuid;
        this.title = title;
        this.author = author;
        this.shelfNumber = shelfNumber;
        this.pageCount = pageCount;
    }
}
