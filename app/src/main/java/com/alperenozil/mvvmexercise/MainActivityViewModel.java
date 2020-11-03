package com.alperenozil.mvvmexercise;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private int count=22;
    private MutableLiveData<Integer> countLiveData=new MutableLiveData<>();

    public void increaseCount() {
        count++;
        countLiveData.setValue(count);
    }

    public MutableLiveData<Integer> getCountLiveData() {
        return countLiveData;
    }
}
