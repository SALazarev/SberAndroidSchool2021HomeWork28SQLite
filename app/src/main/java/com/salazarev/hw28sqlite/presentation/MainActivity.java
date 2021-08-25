package com.salazarev.hw28sqlite.presentation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.salazarev.hw28sqlite.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView listView = findViewById(R.id.bookList);

        MainViewModel viewModel = new ViewModelProvider(
                this, new BooksViewModelFactory(getApplicationContext())
        ).get(MainViewModel.class);
        viewModel.getBooksData().observe(this, books ->
                listView.setAdapter(new BooksAdapter(books)));
    }

}