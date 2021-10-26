package com.example.glowhockey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static String PACKAGE_NAME;
    private TextView easy;
    private TextView medium;
    private TextView hard;
    private LinearLayout lvl_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PACKAGE_NAME = getApplicationContext().getPackageName();

        easy = findViewById(R.id.easy);
        medium = findViewById(R.id.medium);
        hard = findViewById(R.id.hard);
        lvl_btn = findViewById(R.id.lvl_btn);

        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHockeyActivity();
            }
        });
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHockeyActivity();
            }
        });
        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHockeyActivity();
            }
        });

    }
    void openHockeyActivity(){
        Intent intent = new Intent(this, MainHockeyActivity.class);
        startActivity(intent);
    }
}