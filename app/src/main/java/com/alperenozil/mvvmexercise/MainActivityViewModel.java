package com.alperenozil.mvvmexercise;

import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private int count=22;
    public void increaseCount() { count++; }
    public int getCount() {
        return count;
    }
}
