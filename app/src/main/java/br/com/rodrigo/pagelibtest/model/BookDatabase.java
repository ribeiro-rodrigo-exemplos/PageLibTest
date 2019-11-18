package br.com.rodrigo.pagelibtest.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Book.class},version = 1, exportSchema = false)
public abstract class BookDatabase extends RoomDatabase {

    private static BookDatabase instance;

    public abstract BookDAO getBookDAO();

    public synchronized static BookDatabase getInstance(Context context) {

        if(instance == null){
            BookDatabaseCallback callback = new BookDatabaseCallback();
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    BookDatabase.class,
                    "books_db"
            )
              .allowMainThreadQueries()
              .addCallback(callback)
              .build();

            callback.init(instance);
        }

        return instance;
    }
}
