package com.salazarev.hw28sqlite.data.room;

import com.salazarev.hw28sqlite.domain.BooksRepository;
import com.salazarev.hw28sqlite.domain.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BooksRepositoryRoomImpl implements BooksRepository {

    private BookDatabase mBookDatabase;

    public BooksRepositoryRoomImpl(BookDatabase bookDatabase) {
        mBookDatabase = bookDatabase;
    }

    private Book convert(BookRoom bookRoom) {
        return new Book(bookRoom.mId, bookRoom.mUuid, bookRoom.mTitle, bookRoom.mAuthor, bookRoom.mShelfNumber, bookRoom.mPageCount);
    }

    @Override
    public List<Book> books() {
        List<BookRoom> booksRoom = mBookDatabase.bookDao().getBooks();
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < booksRoom.size(); i++) {
            books.add(convert(booksRoom.get(i)));
        }
        return books;
    }

    @Override
    public void addBook(String uuid, String title, String author, int shelfNumber, int pageCount) {
        BookRoom book = new BookRoom(uuid,title,author,shelfNumber,pageCount);
        mBookDatabase.bookDao().insert(book);
    }
}
