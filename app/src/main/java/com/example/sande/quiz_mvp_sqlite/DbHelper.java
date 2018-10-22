package com.example.sande.quiz_mvp_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.sande.quiz_mvp_sqlite.DbContract.*;

public class DbHelper extends SQLiteOpenHelper {

    private static final String TAG = "DbHelper";
    private static final String DATABASE_NAME = "quiz.db";
    private static final int DATABASE_VERSION = 2;

    final String sql = " CREATE TABLE " +
            QuestionsTable.TABLE_NAME + " ( " +
            QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            QuestionsTable.COLUMN_QUESTION + " TEXT, " +
            QuestionsTable.COLUMN_OPT1 + " TEXT, " +
            QuestionsTable.COLUMN_OPT2 + " TEXT, " +
            QuestionsTable.COLUMN_OPT3 + " TEXT, " +
            QuestionsTable.COLUMN_OPT4 + " TEXT, " +
            QuestionsTable.COLUMN_ANSWER + " TEXT " + ")";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME );
        onCreate(db);
    }
}
