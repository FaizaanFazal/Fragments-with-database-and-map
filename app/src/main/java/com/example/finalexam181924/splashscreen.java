package com.example.finalexam181924;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class splashscreen extends AppCompatActivity {
    ImageView img;
    TextView txt;
    Animation top, bottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        img=findViewById(R.id.logo_id);
        txt=findViewById(R.id.splash);
        top= AnimationUtils.loadAnimation(this,R.anim.top_anim);
        bottom=AnimationUtils.loadAnimation(this,R.anim.bottom_anim);
        img.setAnimation(top);
        txt.setAnimation(bottom);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(splashscreen.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        },3000);
    }
}