package com.alperenozil.mvvmexercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewModelProvider.AndroidViewModelFactory androidViewModelFactory=new ViewModelProvider.AndroidViewModelFactory(getApplication());
        MainActivityViewModel model = new ViewModelProvider(this,androidViewModelFactory).get(MainActivityViewModel.class);
        Log.d(TAG, "onCreate: "+model.getCount());
    }
}