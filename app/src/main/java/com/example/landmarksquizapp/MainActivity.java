package com.example.landmarksquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonBegin = findViewById(R.id.button_begin);
        buttonBegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beginQuiz();

            }
        });
    }


    private void beginQuiz() {
        Intent intent = new android.content.Intent(MainActivity.this, QuizActivity.class);
        startActivity(intent);
    }
}