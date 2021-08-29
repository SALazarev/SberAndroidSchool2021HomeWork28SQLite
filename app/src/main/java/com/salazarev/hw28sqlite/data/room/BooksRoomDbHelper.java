package com.salazarev.hw28sqlite.data.room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

public class BooksRoomDbHelper {

    private static final String DATABASE_NAME = "BookShelves.db";

    private static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) { }
    };

    private BooksRoomDbHelper(){}

    public static BookDatabase getDatabase(@Nullable Context context) {
       return Room.databaseBuilder(context.getApplicationContext(), BookDatabase.class,DATABASE_NAME).addMigrations(MIGRATION_2_3).build();
    }
}
