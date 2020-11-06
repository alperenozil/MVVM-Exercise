package com.alperenozil.mvvmexercise.model;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.loader.content.AsyncTaskLoader;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Category.class, Book.class},version = 1)
public abstract class BooksDatabase extends RoomDatabase {
    public abstract CategoryDAO categoryDAO();
    public abstract BookDAO bookDAO();
    private static BooksDatabase instance;
    public static synchronized BooksDatabase getInstance(Context context){
        if(instance==null){
            instance=Room.databaseBuilder(context.getApplicationContext(),
                    BooksDatabase.class,"books_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(callback)
                    .build();
        }
        return instance;
    }
    private static RoomDatabase.Callback callback=new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new InitialDataAsyncTask(instance).execute();
        }
    };
    private static class InitialDataAsyncTask extends AsyncTask<Void,Void,Void>{
        private CategoryDAO categoryDAO;
        private BookDAO bookDAO;

        public InitialDataAsyncTask(BooksDatabase booksDatabase) {
            categoryDAO=booksDatabase.categoryDAO();
            bookDAO=booksDatabase.bookDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Category category1=new Category();
            category1.setCategoryName("text book1");
            category1.setCategoryDescription("text book1 description");
            Category category2=new Category();
            category2.setCategoryName("text book2");
            category2.setCategoryDescription("text book2 description");
            Category category3=new Category();
            category3.setCategoryName("text book3");
            category3.setCategoryDescription("text book3 description");
            categoryDAO.Insert(category1);
            categoryDAO.Insert(category2);
            categoryDAO.Insert(category3);
            Book book1=new Book();
            book1.setBookName("book1");
            book1.setCategoryId(1);
            book1.setUnitPrice("$100");
            Book book2=new Book();
            book2.setBookName("book2");
            book2.setCategoryId(2);
            book2.setUnitPrice("$200");
            bookDAO.Insert(book1);
            bookDAO.Insert(book2);
            return null;
        }
    }
}
