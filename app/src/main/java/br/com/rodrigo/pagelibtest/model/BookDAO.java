package br.com.rodrigo.pagelibtest.model;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface BookDAO {

    @Insert
    Long insert(Book book);

    @Query("SELECT * FROM books ORDER BY id DESC")
    DataSource.Factory<Integer,Book> booksById();


}
