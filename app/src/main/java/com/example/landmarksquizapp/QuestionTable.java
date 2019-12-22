package com.example.landmarksquizapp;

public class QuestionTable {


    /*-------------------MEMBER VARIABLES------------*/

    private String QuestionList[];
    private String Options[][];
    private String correctOptions[];
    public String pictures[];


    /*-----------------CONSTRUCTOR------------------*/
    public QuestionTable() {
        QuestionList = new String[]{
                "Where is the Leaning Tower of Pisa located?",
                "Which continent has the world's deepest coral reef?",
                "What is the capital of Sweden?",
                "Which landmark is shown in this picture?",
                "What is the height of Eiffel Tower in feet?",
                "What is this clock's name?",
                "Which country has world's second tallest mountain, K2?"
        };

        Options = new String[][]{
                {"Italy", "Romania", "France", "Egypt"},
                {"Asia", "Oceania", "Europe", "Africa"},
                {"Berlin", "Beijing", "Colombo", "Stockholm"},
                {"Sydney Opera House", "Royal Opera House", "San Carlo Theatre", "The Estates Theatre"},
                {"560", "1055", "906", "1203"},
                {"Tom", "Harry", "Big Ben", "Steam"},
                {"Japan", "South Africa", "Pakistan", "South Korea"}
        };

        correctOptions = new String[]{
                "Italy",
                "Oceania",
                "Stockholm",
                "Sydney Opera House",
                "906",
                "Big Ben",
                "Pakistan"
        };

        pictures = new String[]{
                "towerofpisa",
                "greatbarrierreef",
                "swedenflag",
                "sydneyoperahouse",
                "eiffeltower",
                "bigben2604a",
                "k2"
        };
    }

    /*--------------MEMBER METHODS-------------------*/
    public int getSizeOfQuestionList() { return this.QuestionList.length; }

    public String getNextImage(int index) { return this.pictures[index]; }

    public String getNextQuestion(int index){ return this.QuestionList[index]; }

    public String getCorrectOption(int index){ return this.correctOptions[index]; }

    public String getOption1(int index) { return this.Options[index][0]; }

    public String getOption2(int index) { return this.Options[index][1]; }

    public String getOption3(int index){
        return this.Options[index][2];
    }

    public String getOption4(int index){
        return this.Options[index][3];
    }
}