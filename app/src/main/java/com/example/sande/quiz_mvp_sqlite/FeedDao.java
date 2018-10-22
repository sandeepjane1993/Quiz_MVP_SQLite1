package com.example.sande.quiz_mvp_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class FeedDao implements DataManagerContract {

    SQLiteDatabase db;
    DbHelper dbhelper;

    FeedDao(Context context){
        dbhelper = new DbHelper(context);
        openDb();
    }
    public void openDb(){
        db = dbhelper.getWritableDatabase();
    }
    public void  closeDb()
    {
        db.close();
    }

    public void createRow(Question question)
    {
        ContentValues cv = new ContentValues();
        cv.put(DbContract.QuestionsTable.COLUMN_QUESTION,question.getQuestion());
        cv.put(DbContract.QuestionsTable.COLUMN_OPT1,question.getOption1());
        cv.put(DbContract.QuestionsTable.COLUMN_OPT2,question.getOption2());
        cv.put(DbContract.QuestionsTable.COLUMN_OPT3,question.getOption3());
        cv.put(DbContract.QuestionsTable.COLUMN_OPT4,question.getOption4());
        cv.put(DbContract.QuestionsTable.COLUMN_ANSWER,question.getAnswer());
        db.insert(DbContract.QuestionsTable.TABLE_NAME,null,cv);
    }

    public List<Question> getRow()
    {
        List<Question> list = new ArrayList<>();
        Cursor cursor = db.query(DbContract.QuestionsTable.TABLE_NAME,null,null,null,null,
                null,null);
        if(cursor.moveToFirst())
        {
            do {
                {
                    Question q = new Question();
                    q.setQuestion(cursor.getString(1));
                    q.setOption1(cursor.getString(2));
                    q.setOption2(cursor.getString(3));
                    q.setOption3(cursor.getString(4));
                    q.setOption4(cursor.getString(5));
                    q.setAnswer(cursor.getString(6));
                    list.add(q);
                }
            }while (cursor.moveToNext());
        }
        cursor.close();
        return  list;
    }

        public void insertDataToDb()
        {
            Question q1 = new Question("sandeep?","UNT","UTD","UTL","UTG","UNT");
            Question q2 = new Question("Berry?","UNT","GTech","UTD","NYU","GTech");
            Question q3 = new Question("Cijan?","UNT","OTD","NIT","OTP","OTD");
            Question q4 = new Question("Yixin?","UNT","NPD","IIT","PTO","IIT");
            Question q5 = new Question("Sandra?","UNT","NYU","IIT","Unknown","Unknown");

            createRow(q1);
            createRow(q2);
            createRow(q3);
            createRow(q4);
            createRow(q5);
        }

        public void getDataFromDb(CallbackContract callBack, int cursorPosition)
        {
            Cursor cursor = db.query(DbContract.QuestionsTable.TABLE_NAME,null,null,
                    null,null,null,null);
            cursor.moveToPosition(cursorPosition);

            String question = cursor.getString(1);
            String opt1 = cursor.getString(2);
            String opt2 = cursor.getString(3);
            String opt3 = cursor.getString(4);
            String opt4 = cursor.getString(5);
            String ans = cursor.getString(6);

            Question q = new Question(question,opt1,opt2,opt3,opt4,ans);
            callBack.displayData(q);

        }

}
