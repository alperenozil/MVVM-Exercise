package com.alperenozil.mvvmexercise.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "categories_table")
public class Category extends BaseObservable {
    @PrimaryKey (autoGenerate = true) // it will increment primary_key automatically
    @ColumnInfo(name = "category_id")
    private int id;
    @ColumnInfo (name="category_name") // I gave columns different names than variables
    private String categoryName;
    @ColumnInfo (name="category_description")
    private String categoryDescription;

    public Category() {
    }

    public Category(int id, String categoryName, String categoryDescription) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    @Bindable
    public int getİd() {
        return id;
    }

    public void setİd(int id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        notifyPropertyChanged(BR.categoryName);
    }

    @Bindable
    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
        notifyPropertyChanged(BR.categoryDescription);
    }
}
