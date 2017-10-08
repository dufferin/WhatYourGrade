package com.example.whatyourgrade;

import android.content.Intent;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;


public class MainActivity extends AppCompatActivity {
    private EditText Name,Score;
    private Button Find,Exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText) findViewById(R.id.name);
        Score = (EditText) findViewById(R.id.score);
        Find = (Button) findViewById(R.id.find);
        Exit = (Button) findViewById(R.id.exit);

        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Are you sure you want to exit?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                MainActivity.this.finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });



        Find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = String.valueOf(Name.getText().toString());
                String score = String.valueOf(Score.getText().toString());
                if(Name.getText().length()==0){
                    Name.setError("โปรดกรอกข้อมูล");
                }else if (Score.getText().length()==0) {
                    Score.setError("โปรดกรอกข้อมูล");
                }else if (Name.getText().length()==0||Score.getText().length()==0){
                    Name.setError("โปรดกรอกข้อมูล");
                    Score.setError("โปรดกรอกข้อมูล");
                }else if(Name.getText().length()!=0&&Score.getText().length()!=0) {
                    Double score_1 = Double.valueOf(Score.getText().toString());
                    String grade = getGrade(score_1);
                    Intent intent = new Intent((MainActivity.this), Result.class);
                    intent.putExtra("name_i", name);
                    intent.putExtra("grade", grade);

                    startActivity(intent);
                }
            }
        });
    }
    private String getGrade(Double score){
        String grade = "";

        if(score < 50){
            grade = "F";
        }else if (score < 60){
            grade = "D";
        }else if (score < 70){
            grade = "C";
        }else if (score < 80){
            grade = "B";
        }else {
            grade = "A";
    }
    return grade;
    }


}
