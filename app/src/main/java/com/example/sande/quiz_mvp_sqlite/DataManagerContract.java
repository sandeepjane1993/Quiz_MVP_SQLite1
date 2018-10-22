package com.example.sande.quiz_mvp_sqlite;

public interface DataManagerContract {


    void insertDataToDb();

    void getDataFromDb(CallbackContract callBack, int cursorPosition);

    interface CallbackContract{
        void displayData(Question q);

        }
}
