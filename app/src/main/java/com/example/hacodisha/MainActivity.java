package com.example.hacodisha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void reg(View view) {
        startActivity(new Intent(MainActivity.this,register.class));
//        finish();
    }

    public void log(View view) {
        startActivity(new Intent(MainActivity.this,login.class));
//        finish();
    }

}