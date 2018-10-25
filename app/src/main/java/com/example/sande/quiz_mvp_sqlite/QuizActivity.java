package com.example.sande.quiz_mvp_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity implements QuizContract.View {

    TextView question;
    CheckBox cb1,cb2,cb3,cb4;
    QuizContract.Presenter presenter;
    Button prev,next;
    int cursorPosition = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        presenter = new QuizPresenter(this);

        presenter.insert(); // to fill the database

        question = findViewById(R.id.tView_question);
        cb1 = findViewById(R.id.checkBox);
        cb2 = findViewById(R.id.checkBox2);
        cb3 = findViewById(R.id.checkBox3);
        cb4 = findViewById(R.id.checkBox4);

        prev = findViewById(R.id.btn_prev);
        next = findViewById(R.id.btn_next);

        presenter.getData(cursorPosition);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cursorPosition<5)
                {

                    presenter.getData(cursorPosition);
                }
                else
                {
                    Toast.makeText(QuizActivity.this, "last page", Toast.LENGTH_SHORT).show();
                }
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void displayData(Question q) {
        question.setText(q.getQuestion());
        cb1.setText(q.getOption1());
        cb2.setText(q.getOption2());
        cb3.setText(q.getOption3());
        cb4.setText(q.getOption4());
        cursorPosition++;
    }
}
