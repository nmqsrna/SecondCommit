package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public  final static String MESSAGE_KEY = "com.example.MyFirstApp.message_key";
    public  final static String EMAIL = "com.example.MyFirstApp.email";
    public  final static String BIRTHDATE = "com.example.MyFirstApp.birthdate";
    public  final static String ADDRESS = "com.example.MyFirstApp.address";
    public  final static String PHONE_NUMBER = "com.example.MyFirstApp.phone_number";

    TextView tv_UserName, tv_Email, tv_Birthday, tv_Address, tv_PhoneNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv_UserName = findViewById(R.id.tvUserName);
        tv_Email = findViewById(R.id.tvEmail);
        tv_Birthday = findViewById(R.id.tvBirthday);
        tv_Address = findViewById(R.id.tvAddress);
        tv_PhoneNum = findViewById(R.id.tvPhoneNum);

        Intent intent = getIntent();

        String message = intent.getStringExtra(MESSAGE_KEY);
        String message1 = intent.getStringExtra(EMAIL);
        String message2 = intent.getStringExtra(BIRTHDATE);
        String message3 = intent.getStringExtra(ADDRESS);
        String message4 = intent.getStringExtra(PHONE_NUMBER);

        tv_UserName.setTextSize(24);
        tv_UserName.setText("Name : " +message );

        tv_Email.setTextSize(24);
        tv_Email.setText("\nEmail : " +message1);

        tv_Birthday.setTextSize(24);
        tv_Birthday.setText("\nBirth Date : " +message2);

        tv_Address.setTextSize(24);
        tv_Address.setText("\nAddress : "+message3);

        tv_PhoneNum.setTextSize(24);
        tv_PhoneNum.setText("\nPhone Number: " +message4);

    }
}