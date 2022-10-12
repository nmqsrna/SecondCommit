package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public  final static String MESSAGE_KEY = "com.example.MyFirstApp.message_key";
    public  final static String BIRTHDATE = "com.example.MyFirstApp.birthdate";
    public  final static String ADDRESS = "com.example.MyFirstApp.address";
    public  final static String PHONE_NUMBER = "com.example.MyFirstApp.phone_number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MESSAGE_KEY);
        String message1 = intent.getStringExtra(BIRTHDATE);
        String message2 = intent.getStringExtra(ADDRESS);
        String message3 = intent.getStringExtra(PHONE_NUMBER);

        TextView textView = new TextView(this);
        textView.setTextSize(25);
        textView.setText("Name : " +message +"\nBirth Date : " +message1 +"\nAddress : "+message2 +"\nPhone Num. : "+message3);
        setContentView(textView);


    }


}