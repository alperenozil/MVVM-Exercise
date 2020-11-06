package com.alperenozil.mvvmexercise.model;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {Category.class, Book.class},version = 1)
public abstract class BooksDatabase extends RoomDatabase {
}
