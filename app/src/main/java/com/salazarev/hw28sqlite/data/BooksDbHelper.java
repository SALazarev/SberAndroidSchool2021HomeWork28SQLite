package com.salazarev.hw28sqlite.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BooksDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "BookShelves.db";

    public BooksDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + BooksTable.NAME + " (" +
                BooksTable.Columns.ID + " integer PRIMARY KEY autoincrement, " +
                BooksTable.Columns.UUID + " text," +
                BooksTable.Columns.TITLE + " text, " +
                BooksTable.Columns.AUTHOR + " text, " +
                BooksTable.Columns.SHELF_NUMBER + " integer" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE " + BooksTable.NAME + " ADD " + BooksTable.Columns.PAGE_COUNT + " integer");
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(BooksTable.Columns.PAGE_COUNT, 451);
        db.update(BooksTable.NAME, contentValues, null, null);
    }
}
