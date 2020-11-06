package com.alperenozil.mvvmexercise.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BookDAO {
    @Insert
    void Insert(Book book);
    @Update
    void Update(Book book);
    @Delete
    void Delete(Book book);

    @Query("SELECT * FROM book_table")
    LiveData<List<Book>> getAllBooks();

    @Query("SELECT * FROM book_table WHERE category_id==:category_id")
    LiveData<List<Book>> getBooks(int category_id); // gets books from this category id

}
