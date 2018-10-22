package com.example.sande.quiz_mvp_sqlite;

import android.provider.BaseColumns;

public class DbContract {

    DbContract(){}

    public static class QuestionsTable implements BaseColumns {

        public static final String TABLE_NAME = "quiz_questions";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_OPT1 = "option1";
        public static final String COLUMN_OPT2 = "option2";
        public static final String COLUMN_OPT3 = "option3";
        public static final String COLUMN_OPT4 = "option4";
        public static final String COLUMN_ANSWER = "answer";

    }
}
