package com.nsu.tatianadementeva.tivenue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class TiVenueActivity extends AppCompatActivity {

    //region UI Outlets
    private TextView questionTextView;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    private ListView listOfMeetings; //our code
    //endregion

    //region Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ti_venue);

        if(null == savedInstanceState ){
            //first launch
        }else {
            //
        }
        listOfMeetings = findViewById(R.id.list_of_meetings);
/*
        questionTextView = findViewById(R.id.question_text_view);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionTextView.setText(R.string.button_1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionTextView.setText(R.string.button_2);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionTextView.setText(R.string.button_3);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionTextView.setText(R.string.button_4);
            }
        });*/
    }
    //endregion
}
