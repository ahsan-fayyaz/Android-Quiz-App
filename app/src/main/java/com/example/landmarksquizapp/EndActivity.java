package com.example.landmarksquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EndActivity extends AppCompatActivity {

    private TextView viewFinalScore;
    private Button buttonRestart;
    private Button buttonGoToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        viewFinalScore = findViewById(R.id.final_score);
        Bundle bundle = getIntent().getExtras();
        int finalScore = bundle.getInt("Final Score");
        viewFinalScore.setText("Final Score: " + finalScore);

        buttonGoToMain = findViewById(R.id.go_to_main);
        buttonRestart = findViewById(R.id.restart);


        buttonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EndActivity.this.finish();
                Intent intent = new Intent(EndActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });


        buttonGoToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EndActivity.this.finish();
                Intent intent = new Intent(EndActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });


    }
}
