package com.example.sande.quiz_mvp_sqlite;

import android.content.Context;

public class DataManager implements DataManagerContract {

    DataManagerContract localData;

    public DataManager(Context context) {
        localData = new FeedDao(context);
    }


    @Override
    public void insertDataToDb() {

        localData.insertDataToDb();
    }

    @Override
    public void getDataFromDb(CallbackContract callBack, int cursorPosition) {

        localData.getDataFromDb(callBack,cursorPosition);
    }


}
