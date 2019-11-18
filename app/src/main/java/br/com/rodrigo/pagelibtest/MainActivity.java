package br.com.rodrigo.pagelibtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import br.com.rodrigo.pagelibtest.model.Book;
import br.com.rodrigo.pagelibtest.viewmodel.BookViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BookViewModel viewModel = ViewModelProviders.of(this).get(BookViewModel.class);

        RecyclerView recyclerView = findViewById(R.id.rv_books);
        final BookAdapter adapter = new BookAdapter();
        viewModel.getBooksList().observe(this, new Observer<PagedList<Book>>() {
            @Override
            public void onChanged(PagedList<Book> books) {
                Log.i("books",books.getConfig().prefetchDistance+" valores");
                adapter.submitList(books);
            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
