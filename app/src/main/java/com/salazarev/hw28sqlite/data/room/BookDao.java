package com.salazarev.hw28sqlite.data.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.salazarev.hw28sqlite.data.BooksTable;

import java.util.List;

@Dao
public interface BookDao {
    @Insert
    void insert(BookRoom book);
    @Query("SELECT * FROM "+ BooksTable.NAME)
    List<BookRoom> getBooks();
}
