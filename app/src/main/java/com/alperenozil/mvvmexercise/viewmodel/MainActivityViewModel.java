package com.alperenozil.mvvmexercise.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.alperenozil.mvvmexercise.model.Book;
import com.alperenozil.mvvmexercise.model.Category;
import com.alperenozil.mvvmexercise.model.EBookShopRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private EBookShopRepository eBookShopRepository;
    private LiveData<List<Category>> allCategories;
    private LiveData<List<Book>> selectedCategoryBooks;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        eBookShopRepository=new EBookShopRepository(application);
    }

    public LiveData<List<Category>> getAllCategories() {
        allCategories=eBookShopRepository.getCategories();
        return allCategories;
    }

    public LiveData<List<Book>> getSelectedCategoryBooks(int categoryId) {
        selectedCategoryBooks=eBookShopRepository.getBooks(categoryId);
        return selectedCategoryBooks;
    }

    public void addNewBook(Book book){
        eBookShopRepository.insertBook(book);
    }
    public void updateBook(Book book){
        eBookShopRepository.UpdateBook(book);
    }
    public void deleteBook(Book book){
        eBookShopRepository.DeleteBook(book);
    }


}
