package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.app.DatePickerDialog;
import android.widget.Toast;
import java.util.Calendar;

public class FirstActivity extends AppCompatActivity {

    EditText etName,etAddress, etPhoneNum, etDate, etEmail;
    DatePickerDialog datePickerDialog;
    Button btnName;

    public  final static String MESSAGE_KEY = "com.example.MyFirstApp.message_key";
    public  final static String EMAIL= "com.example.MyFirstApp.email";
    public  final static String BIRTHDATE= "com.example.MyFirstApp.birthdate";
    public  final static String ADDRESS= "com.example.MyFirstApp.address";
    public  final static String PHONE_NUMBER = "com.example.MyFirstApp.phone_number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        etEmail = findViewById(R.id.etEmail);
        btnName = findViewById(R.id.btnName);
        etDate =  findViewById(R.id.etDate);

        etDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(FirstActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                etDate.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
    }

    public void send_data(View view) {

        String emailToText = etEmail.getText().toString();

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etDate = findViewById(R.id.etDate);
        etAddress = findViewById(R.id.etAddress);
        etPhoneNum = findViewById(R.id.etPhoneNum);
        btnName = findViewById(R.id.btnName);

        String message = etName.getText().toString();
        String message1 = etEmail.getText().toString();
        String message2 = etDate.getText().toString();
        String message3 = etAddress.getText().toString();
        String message4 = etPhoneNum.getText().toString();

        if (!emailToText.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(message1).matches()) {
            Toast.makeText(this, "Successfully Registered.", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, SecondActivity.class);

            intent.putExtra(MESSAGE_KEY,message);
            intent.putExtra(EMAIL,message1);
            intent.putExtra(BIRTHDATE,message2);
            intent.putExtra(ADDRESS,message3);
            intent.putExtra(PHONE_NUMBER,message4);

            startActivity(intent);

            } else {
                Toast.makeText(this, "Invalid Email Address!", Toast.LENGTH_SHORT).show();
            }
    }
}

