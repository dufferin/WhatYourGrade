package com.example.whatyourgrade;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grade_result);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name_i");
        String g = intent.getStringExtra("grade");
        TextView v = (TextView) findViewById(R.id.name);
        TextView vv = (TextView) findViewById(R.id.grade);
        v.setText(name);
        vv.setText(g);
    }

}

