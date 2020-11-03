package com.alperenozil.mvvmexercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button buttonIncrease;
    private TextView textViewCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewModelProvider.AndroidViewModelFactory androidViewModelFactory=new ViewModelProvider.AndroidViewModelFactory(getApplication());
        MainActivityViewModel model = new ViewModelProvider(this,androidViewModelFactory).get(MainActivityViewModel.class);
        buttonIncrease=findViewById(R.id.buttonIncrease);
        textViewCount=findViewById(R.id.countTextView);
        textViewCount.setText(""+model.getCount());
        buttonIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.increaseCount();
                textViewCount.setText(""+model.getCount());
                Log.d(TAG, "onCreate: "+model.getCount());
            }
        });
    }
}