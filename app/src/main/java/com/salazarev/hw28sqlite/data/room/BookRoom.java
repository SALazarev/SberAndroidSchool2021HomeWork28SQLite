package com.salazarev.hw28sqlite.data.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.salazarev.hw28sqlite.data.BooksTable;

@Entity(tableName = BooksTable.NAME)
public class BookRoom {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = BooksTable.Columns.ID)
    public int mId;
    @ColumnInfo(name = BooksTable.Columns.UUID)
    public String mUuid;
    @ColumnInfo(name = BooksTable.Columns.TITLE)
    public String mTitle;
    @ColumnInfo(name=BooksTable.Columns.AUTHOR)
    public String mAuthor;
    @ColumnInfo(name=BooksTable.Columns.SHELF_NUMBER)
    public int mShelfNumber;
    @ColumnInfo(name=BooksTable.Columns.PAGE_COUNT, defaultValue = "2")
    public int mPageCount;

    public BookRoom(int id, String uuid, String title, String author, int shelfNumber, int pageCount){
        mId = id;
        mUuid = uuid;
        mTitle = title;
        mAuthor = author;
        mShelfNumber = shelfNumber;
        mPageCount = pageCount;
    }

    @Ignore
    public BookRoom(String uuid, String title, String author, int shelfNumber, int pageCount){
        mUuid = uuid;
        mTitle = title;
        mAuthor = author;
        mShelfNumber = shelfNumber;
        mPageCount = pageCount;
    }
}
