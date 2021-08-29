package com.salazarev.hw28sqlite.data.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {BookRoom.class}, version = 3)
public abstract class BookDatabase extends RoomDatabase {
    public abstract BookDao bookDao();
}
