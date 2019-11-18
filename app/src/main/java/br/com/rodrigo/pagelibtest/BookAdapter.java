package br.com.rodrigo.pagelibtest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import br.com.rodrigo.pagelibtest.model.Book;

public class BookAdapter extends PagedListAdapter<Book, BookAdapter.BookViewHolder> {

    private  static DiffUtil.ItemCallback<Book> diffCallback = new DiffUtil.ItemCallback<Book>() {
        @Override
        public boolean areItemsTheSame(@NonNull Book oldItem, @NonNull Book newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Book oldItem, @NonNull Book newItem) {
            return oldItem.equals(newItem);
        }
    };

    public BookAdapter() {
        super(diffCallback);
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.book_item,parent,false);

        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {

        Book book = getItem(position);

        if(book != null) {
            holder.bindTo(book);
        }
    }

    class BookViewHolder extends RecyclerView.ViewHolder{

        public TextView tvName;
        public TextView tvPrice;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.item_name);
            tvPrice = itemView.findViewById(R.id.item_price);
        }

        public void bindTo(Book book){
            tvName.setText(book.getName());
            tvPrice.setText(book.getPrice());
        }
    }


}
