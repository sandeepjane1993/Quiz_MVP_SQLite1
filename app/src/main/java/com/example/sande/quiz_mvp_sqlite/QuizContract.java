package com.example.sande.quiz_mvp_sqlite;

public interface QuizContract {

    interface View{


        void displayData(Question q);
    }
    interface Presenter{


        void insert();

        void getData(int cursorPosition);
    }

}
