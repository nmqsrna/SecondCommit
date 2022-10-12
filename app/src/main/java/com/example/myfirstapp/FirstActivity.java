package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;


import java.util.Calendar;


public class FirstActivity extends AppCompatActivity {

    EditText etName;
    EditText etAddress;
    EditText etPhoneNum;
    EditText date;
    DatePickerDialog datePickerDialog;
    Button btnName;

    public  final static String MESSAGE_KEY = "com.example.MyFirstApp.message_key";
    public  final static String BIRTHDATE= "com.example.MyFirstApp.birthdate";
    public  final static String ADDRESS= "com.example.MyFirstApp.address";
    public  final static String PHONE_NUMBER = "com.example.MyFirstApp.phone_number";
    //public  final static String BIRTH = "com.example.MyFirstApp.birth";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        date = (EditText) findViewById(R.id.date);
        // perform click event on edit text
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(FirstActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

    }


    public void send_data(View view) {

        etName = findViewById(R.id.etName);
        date = findViewById(R.id.date);
        etAddress = findViewById(R.id.etAddress);
        etPhoneNum = findViewById(R.id.etPhoneNum);
        btnName = findViewById(R.id.btnName);

        String message = etName.getText().toString();
        String message1 = date.getText().toString();
        String message2 = etAddress.getText().toString();
        String message3 = etPhoneNum.getText().toString();

        Intent intent = new Intent (FirstActivity.this, SecondActivity.class );

        intent.putExtra(MESSAGE_KEY,message);
        intent.putExtra(BIRTHDATE,message1);
        intent.putExtra(ADDRESS,message2);
        intent.putExtra(PHONE_NUMBER,message3);

        startActivity(intent);
    }

}