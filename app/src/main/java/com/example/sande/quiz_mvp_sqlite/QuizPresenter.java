package com.example.sande.quiz_mvp_sqlite;

public class QuizPresenter implements QuizContract.Presenter,DataManagerContract.CallbackContract {
    QuizContract.View view;
    DataManagerContract dataManager;
    public QuizPresenter(QuizActivity quizActivity) {
        view = quizActivity;
        dataManager = new DataManager(quizActivity);
    }


    @Override
    public void insert() {
        dataManager.insertDataToDb();
    }

    @Override
    public void getData(int cursorPosition) {
        dataManager.getDataFromDb(this,cursorPosition);
    }


    @Override
    public void displayData(Question q) {
        view.displayData(q);
    }
}
