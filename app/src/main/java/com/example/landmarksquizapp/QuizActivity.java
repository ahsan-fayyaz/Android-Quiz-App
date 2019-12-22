package com.example.landmarksquiz;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.landmarksquizapp.R;

public class QuizActivity extends AppCompatActivity {

    /*----------------PRIVATE MEMBERS-----------*/
    private QuestionTable questionTableInstance = new QuestionTable();
    private int totalQuestions = questionTableInstance.getSizeOfQuestionList();
    public static int score ;
    private int index;
    private int currentQuestionNumber;
    private String correctOption;

    /*----------------BUTTON CONTROLLERS, TEXTVIEWS, IMAGEVIEWS----------*/
    private TextView viewScore;
    private TextView viewQuestionNumber;
    private TextView viewQuestion;
    private Button buttonOption1, buttonOption2, buttonOption3, buttonOption4;
    private Button buttonQuit, buttonSkip;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        /*---variables---*/
        score = 0;
        index = 0;
        currentQuestionNumber = 1;
        correctOption = "";

        /*-----connect the IDs to member variables*/
        imageView = findViewById(R.id.imageView);
        viewScore = findViewById(R.id.text_view_score);
        viewQuestionNumber = findViewById(R.id.text_view_question_number);
        viewQuestion = findViewById(R.id.question);
        buttonOption1 = findViewById(R.id.option1);
        buttonOption2 = findViewById(R.id.option2);
        buttonOption3 = findViewById(R.id.option3);
        buttonOption4 = findViewById(R.id.option4);
        buttonQuit = findViewById(R.id.quit);
        buttonSkip = findViewById(R.id.skipQuestion);

        nextQuestion();
        updateScreenQuestionNumber();
        updateScreenScore(score);

        /*-------LISTENERS FOR BUTTONS----------*/

        /*----------Quit button-----------*/
        buttonQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToEndPage();
            }
        });


        /*----------Skip button-----------*/
        buttonSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQuestionNumber >= totalQuestions)
                    goToEndPage();
                else
                    updateGeneric();
            }
        });


        buttonOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (currentQuestionNumber >= totalQuestions) {

                    if (buttonOption1.getText().toString().equals(correctOption)) {
                        score++;
                        toastCorrectAnswer();
                    }
                    else {
                        toastWrongAnswer();
                    }
                    goToEndPage();
                }
                else {

                    if (buttonOption1.getText().toString().equals(correctOption)) {
                        score++;
                        toastCorrectAnswer();
                    }
                    else {
                        toastWrongAnswer();
                    }
                    /*UPDATE SCREEN QUESTION REGARDLESS OF SCORE*/
                    updateGeneric();
                }
            }

        });

        buttonOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (currentQuestionNumber >= totalQuestions) {

                    if (buttonOption2.getText().toString().equals(correctOption)) {
                        score++;
                        toastCorrectAnswer();
                    }
                    else{
                        toastWrongAnswer();
                    }
                    goToEndPage();
                }
                else {

                    if (buttonOption2.getText().toString().equals(correctOption)) {
                        score++;
                        toastCorrectAnswer();
                    }
                    else{
                        toastWrongAnswer();
                    }
                    /*UPDATE SCREEN QUESTION REGARDLESS OF SCORE*/
                    updateGeneric();
                }
            }
        });

        buttonOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (currentQuestionNumber >= totalQuestions) {

                    if (buttonOption3.getText().toString().equals(correctOption)) {
                        score++;
                        toastCorrectAnswer();
                    }
                    else {
                        toastWrongAnswer();
                    }
                    goToEndPage();
                }
                else {

                    if (buttonOption3.getText().toString().equals(correctOption)) {
                        score++;
                        toastCorrectAnswer();
                    }
                    else {
                        toastWrongAnswer();
                    }
                    /*UPDATE SCREEN QUESTION REGARDLESS OF SCORE*/
                    updateGeneric();
                }
            }
        });


        buttonOption4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (currentQuestionNumber >= totalQuestions) {

                    if (buttonOption4.getText().toString().equals(correctOption)) {
                        toastCorrectAnswer();
                        score++;
                    }
                    else{
                        toastWrongAnswer();
                    }
                    goToEndPage();
                }
                else {

                    if (buttonOption4.getText().toString().equals(correctOption)) {
                        score++;
                        toastCorrectAnswer();
                    }
                    else {
                        toastWrongAnswer();
                    }
                    /*UPDATE SCREEN QUESTION REGARDLESS OF SCORE*/
                    updateGeneric();
                }
            }
        });
    }

    /*---------------HELPER METHODS----------------*/

    /*----------Method to update screen score-----------*/
    public void updateScreenScore(int scoreValue) {
        //set the value of Score on screen to current score
        viewScore.setText("Score: " + scoreValue);
    }

    /*----------Method to set next question-----------*/
    public void updateScreenQuestionNumber() {
        viewQuestionNumber.setText("Question: " + currentQuestionNumber + "/" + totalQuestions);
    }

    /*----------Method to fetch next question-----------*/
    public void nextQuestion() {
        String temp = questionTableInstance.getNextImage(index);
        imageView.setImageResource(getImageId(this, temp));

        viewQuestion.setText(questionTableInstance.getNextQuestion(index));
        buttonOption1.setText(questionTableInstance.getOption1(index));
        buttonOption2.setText(questionTableInstance.getOption2(index));
        buttonOption3.setText(questionTableInstance.getOption3(index));
        buttonOption4.setText(questionTableInstance.getOption4(index));

        correctOption = questionTableInstance.getCorrectOption(index);
    }

    /*----------Method to go to end page-----------*/
    private void goToEndPage() {
        Intent intent = new Intent(QuizActivity.this, EndActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("Final Score", score);
        intent.putExtras(bundle);
        QuizActivity.this.finish();
        startActivity(intent);
    }


    public static int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }


    /*----------Method to Toast Correct Answer-----------*/
    public void toastCorrectAnswer(){
        Toast toast = Toast.makeText(getBaseContext(), "CORRECT!" , Toast.LENGTH_SHORT );
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        TextView v = toast.getView().findViewById(android.R.id.message);
        v.setTextColor(Color.GREEN);
        v.setTextSize(32);
        toast.show();

    }

    /*----------Method to Toast Wrong Answer-----------*/
    public void toastWrongAnswer(){
        Toast toast = Toast.makeText(getBaseContext(), "INCORRECT!" , Toast.LENGTH_SHORT );
        toast.setGravity(Gravity.CENTER, 0, 0);
        TextView v = toast.getView().findViewById(android.R.id.message);
        v.setTextColor(Color.RED);
        v.setTextSize(32);
        toast.show();
    }
    /*----------Method to update fields-----------*/
    public void updateGeneric(){
        updateScreenScore(score);
        index++;
        currentQuestionNumber++;
        updateScreenQuestionNumber();
        nextQuestion();
    }
}
