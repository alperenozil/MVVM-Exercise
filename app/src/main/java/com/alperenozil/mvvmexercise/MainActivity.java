package com.alperenozil.mvvmexercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import com.alperenozil.mvvmexercise.model.Book;
import com.alperenozil.mvvmexercise.model.Category;
import com.alperenozil.mvvmexercise.viewmodel.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel mainActivityViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityViewModel= ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mainActivityViewModel.getAllCategories().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                for (Category category:categories) {
                    Log.d("alperenozil", "onChanged: "+category.getCategoryName());
                }
            }
        });
        mainActivityViewModel.getSelectedCategoryBooks(3).observe(this, new Observer<List<Book>>() {
            @Override
            public void onChanged(List<Book> books) {
                for (Book book:books) {
                    Log.d("alperenozil", "onChanged: "+book.getBookName());
                }
            }
        });
    }
}