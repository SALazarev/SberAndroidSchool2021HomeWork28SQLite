package com.salazarev.hw28sqlite.domain;

import com.salazarev.hw28sqlite.domain.model.Book;

import java.util.List;
import java.util.UUID;


public class BooksInteractor {

    private final BooksRepository mRepository;

    public BooksInteractor(BooksRepository repository) {
        mRepository = repository;
    }

    public List<Book> getBooks() {
        return mRepository.books();
    }

    public void addData() {
        mRepository.addBook(UUID.randomUUID().toString(), "Название книги", "Автор", 1, 451);
    }
}
