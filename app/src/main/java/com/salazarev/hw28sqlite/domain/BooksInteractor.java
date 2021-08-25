package com.salazarev.hw28sqlite.domain;

import com.salazarev.hw28sqlite.domain.model.Book;

import java.util.List;



public class BooksInteractor {

    private final BooksRepository mRepository;

    public BooksInteractor(BooksRepository repository) {
        mRepository = repository;
    }

    public List<Book> getBooks() {
        mRepository.initRepository();
        return mRepository.books();
    }
}
