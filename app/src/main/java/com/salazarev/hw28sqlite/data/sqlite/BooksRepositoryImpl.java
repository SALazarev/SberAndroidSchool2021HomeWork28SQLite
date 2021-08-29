package com.salazarev.hw28sqlite.data.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.salazarev.hw28sqlite.data.BooksTable;
import com.salazarev.hw28sqlite.domain.BooksRepository;
import com.salazarev.hw28sqlite.domain.model.Book;

import java.util.ArrayList;
import java.util.List;


public class BooksRepositoryImpl implements BooksRepository {

    private BooksDbHelper mHelper;

    public BooksRepositoryImpl(BooksDbHelper helper) {
        mHelper = helper;
    }

    @Override
    public void addBook(String uuid, String title, String author, int shelfNumber, int pageCount) {
        SQLiteDatabase database = mHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(BooksTable.Columns.UUID, uuid);
        values.put(BooksTable.Columns.TITLE, title);
        values.put(BooksTable.Columns.AUTHOR, author);
        values.put(BooksTable.Columns.SHELF_NUMBER, shelfNumber);
        values.put(BooksTable.Columns.PAGE_COUNT, pageCount);
        database.insert(BooksTable.NAME, null, values);
    }

    @Override
    public List<Book> books() {
        SQLiteDatabase database = mHelper.getReadableDatabase();

        String[] columns = {
                BooksTable.Columns.ID,
                BooksTable.Columns.UUID,
                BooksTable.Columns.TITLE,
                BooksTable.Columns.AUTHOR,
                BooksTable.Columns.SHELF_NUMBER,
                BooksTable.Columns.PAGE_COUNT
        };

        String sortOrder = BooksTable.Columns.TITLE + " DESC";
        List<Book> result = new ArrayList<>();
        try (Cursor cursor = database.query(BooksTable.NAME, columns, null, null, null, null, sortOrder)) {
            while (cursor.moveToNext()) {
                result.add(new Book(
                        cursor.getLong(cursor.getColumnIndex(BooksTable.Columns.ID)),
                        cursor.getString(cursor.getColumnIndex(BooksTable.Columns.UUID)),
                        cursor.getString(cursor.getColumnIndex(BooksTable.Columns.TITLE)),
                        cursor.getString(cursor.getColumnIndex(BooksTable.Columns.AUTHOR)),
                        cursor.getInt(cursor.getColumnIndex(BooksTable.Columns.SHELF_NUMBER)),
                        cursor.getInt(cursor.getColumnIndex(BooksTable.Columns.PAGE_COUNT))
                ));
            }
        }
        return result;
    }
}
