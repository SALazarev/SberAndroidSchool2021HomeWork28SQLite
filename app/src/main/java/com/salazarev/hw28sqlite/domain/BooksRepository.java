package com.salazarev.hw28sqlite.domain;

import com.salazarev.hw28sqlite.domain.model.Book;

import java.util.List;



public interface BooksRepository {

    void initRepository();

    List<Book> books();

}
