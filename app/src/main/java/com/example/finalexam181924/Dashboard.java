package com.example.finalexam181924;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalexam181924.frags.Viewhobbyfrag;
import com.example.finalexam181924.frags.addfrag;

public class Dashboard extends AppCompatActivity {
    Button btnadd,btnview,btnmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().hide();
        btnadd=findViewById(R.id.btnadd);
        btnview=findViewById(R.id.btnhobby);
        btnmap=findViewById(R.id.btnmap);
        getSupportFragmentManager().beginTransaction().add(R.id.container,new addfrag()).commit();


        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new addfrag()).commit();            }
        });

        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new Viewhobbyfrag()).commit();            }
        });

        btnmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent var3 = new Intent(Dashboard.this ,MapsActivity.class);
                startActivity(var3);
            }
        });
    }
}