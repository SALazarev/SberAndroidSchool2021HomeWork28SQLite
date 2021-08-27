package com.salazarev.hw28sqlite.domain;

import com.salazarev.hw28sqlite.domain.model.Book;

import java.util.List;


public interface BooksRepository {

    List<Book> books();

    void addBook(String uuid, String title, String author, int shelfNumber);

}
