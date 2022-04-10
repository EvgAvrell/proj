package com.example.androidstartproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ToInfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_inf);

        TextView tv = (TextView) findViewById(R.id.tv);
        String str = getIntent().getStringExtra("et");
        tv.setText(str);



    }
}