package br.com.rodrigo.pagelibtest.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import br.com.rodrigo.pagelibtest.model.Book;
import br.com.rodrigo.pagelibtest.model.BookDAO;
import br.com.rodrigo.pagelibtest.model.BookDatabase;

public class BookViewModel extends AndroidViewModel {

    private final LiveData<PagedList<Book>> booksList;

    public BookViewModel(@NonNull Application application) {
        super(application);

        BookDAO bookDAO = BookDatabase.getInstance(application.getApplicationContext()).getBookDAO();
        booksList = new LivePagedListBuilder<>(bookDAO.booksById(), 50).build();
    }

    public LiveData<PagedList<Book>> getBooksList() {
        return booksList;
    }
}
