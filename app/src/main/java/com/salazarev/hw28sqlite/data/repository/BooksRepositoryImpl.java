package com.salazarev.hw28sqlite.data.repository;

import com.salazarev.hw28sqlite.domain.BooksRepository;
import com.salazarev.hw28sqlite.domain.model.Book;

import java.util.Collections;
import java.util.List;



public class BooksRepositoryImpl implements BooksRepository {

    public BooksRepositoryImpl() {
    }

    @Override
    public void initRepository() {
    }

    @Override
    public List<Book> books() {
        return Collections.emptyList();
    }
}
