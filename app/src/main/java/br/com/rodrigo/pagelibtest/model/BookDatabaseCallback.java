package br.com.rodrigo.pagelibtest.model;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.Executors;

public class BookDatabaseCallback extends RoomDatabase.Callback {

    private BookDAO bookDAO;

    public void init(BookDatabase bookDatabase){
        bookDAO = bookDatabase.getBookDAO();
    }

    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
        super.onCreate(db);

        Executors.newFixedThreadPool(1).execute(new Runnable() {
            @Override
            public void run() {
                for(int i=1; i <= 200; i++){
                    Book book = new Book("book - "+i,"2.9"+i);
                    bookDAO.insert(book);
                }
            }
        });
    }
}
