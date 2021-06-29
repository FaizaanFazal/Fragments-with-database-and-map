package com.example.finalexam181924;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtid, edtname, edtpass,edtlogname,edtlogpass;
    Button btnsignup, btnlogin;
    DBhelper sqliteDB_helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtid = findViewById(R.id.edt_id);
        edtname = findViewById(R.id.edt_name);
        edtpass = findViewById(R.id.edt_password);
        edtlogname=findViewById(R.id.edt_logname);
        edtlogpass=findViewById(R.id.edt_logpassword);
        btnsignup = findViewById(R.id.btn_signup);
        btnlogin = findViewById(R.id.btn_login);

        sqliteDB_helper = new DBhelper(this);
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = edtid.getText().toString();
                String name = edtname.getText().toString();
                String pass = edtpass.getText().toString();

                boolean checkSaved = sqliteDB_helper.insertData(id, name, pass);
                if (checkSaved == true) {
                    Toast.makeText(MainActivity.this, "saved successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Not Saved", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }

    public void login() {
        String uname,password;
        uname=edtlogname.getText().toString();
        password=edtlogpass.getText().toString();
        Cursor eachRecord_cursor = sqliteDB_helper.getStudentData(uname,password);
        if (eachRecord_cursor.getCount() == 0) {
            Toast.makeText(MainActivity.this, "Wrong Credentials", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
            String msg;
            msg=eachRecord_cursor.getString(1);
            Intent var2 = new Intent(this , Dashboard.class);
            var2.putExtra("name" , msg);
            startActivity(var2);
            finish();

        }
    }
}