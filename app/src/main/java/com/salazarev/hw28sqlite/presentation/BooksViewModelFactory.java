package com.salazarev.hw28sqlite.presentation;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.salazarev.hw28sqlite.data.BooksDbHelper;
import com.salazarev.hw28sqlite.data.repository.BooksRepositoryImpl;
import com.salazarev.hw28sqlite.domain.BooksInteractor;


class BooksViewModelFactory implements ViewModelProvider.Factory {

    private final Context mContext;

    public BooksViewModelFactory(Context context) {
        mContext = context;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> aClass) {
        return (T) new MainViewModel(
                new BooksInteractor(
                        new BooksRepositoryImpl(new BooksDbHelper(mContext)
                        )));
    }
}
