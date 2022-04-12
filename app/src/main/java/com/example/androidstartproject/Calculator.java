package com.example.androidstartproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class Calculator extends AppCompatActivity {

    public static final String  LogcatTag = "CALCULATOR ACTIVITY";
    public static final String Lifecycle = "LIFECYCLE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(Lifecycle, "I'm onCreate and i'm started");
        setContentView(R.layout.activity_calculator);

        final Button calculate = (Button) findViewById(R.id.calc);

   /*     // Context тренинг
        TextView textView = new TextView(this);
        ListAdapter adapter = new SimpleCursorAdapter(getApplicationContext(),);

        ////
        getSystemService(LAYOUT_INFLATER_SERVICE);

         ///
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("PREFS", MODE_PRIVATE);

        ////*/


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LogcatTag, "Button have been pushed");
                try {
                    calcuclateAnswe();
                }
                catch (Exception e){

                    //перерывание
                    /* e.printStackTrace();
                    Toast.makeText(Calculator.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    finish();*/

                    // восстоновление
                    e.printStackTrace();
                    Toast.makeText(Calculator.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    dropFields();

                }

                Intent i = new Intent(Calculator.this, MainActivity.class);
                //startActivity(i);

            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(Lifecycle, "I'm onStart and i'm started");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(Lifecycle, "I'm onStop and i'm started");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(Lifecycle, "I'm onDestroy and i'm started");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(Lifecycle, "I'm onPause and i'm started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(Lifecycle, "I'm onResume and i'm started");
    }

    private void dropFields(){
        EditText numOne = (EditText) findViewById(R.id.editTextNumberDecimal);
        EditText numTwo = (EditText) findViewById(R.id.editTextNumberDecimal2);

        RadioButton add = (RadioButton) findViewById(R.id.add);
        RadioButton sub = (RadioButton) findViewById(R.id.subtract);
        RadioButton multiple = (RadioButton) findViewById(R.id.multiple);
        RadioButton divide = (RadioButton) findViewById(R.id.divide);

        numOne.setText("0");
        numTwo.setText("0");
        add.setChecked(true);

        TextView answer = (TextView) findViewById(R.id.result);

        answer.setText(" Now we have problems. Try againg later ");
    }

    private void calcuclateAnswe() throws ArithmeticException, IOException {
        EditText numOne = (EditText) findViewById(R.id.editTextNumberDecimal);
        EditText numTwo = (EditText) findViewById(R.id.editTextNumberDecimal2);

        RadioButton add = (RadioButton) findViewById(R.id.add);
        RadioButton sub = (RadioButton) findViewById(R.id.subtract);
        RadioButton multiple = (RadioButton) findViewById(R.id.multiple);
        RadioButton divide = (RadioButton) findViewById(R.id.divide);

        numOne.setText("0");
        numTwo.setText("0");
        add.setChecked(true);

        TextView answer = (TextView) findViewById(R.id.result);

        Log.d(LogcatTag, "All view have been founded");



        float numone = 0;
        float numtwo = 0;
        String num1 = numOne.getText().toString();
        String num2 = numTwo.getText().toString();
        if (!num1.equals("") && num1 != null) {
            numone = Integer.parseInt(numOne.getText().toString());
        }

        if (!num2.equals("") && num2 != null) {
            numtwo = Integer.parseInt(numTwo.getText().toString());
        }

        Log.d(LogcatTag, "Successfully graded data from input fields");
        Log.d(LogcatTag,"numone is:"+ numone +"; "+" numtwo is: " + numtwo);

        float solution = 0;

        if(add.isChecked()){
            Log.d(LogcatTag, "Operation is add");
            solution = numone + numtwo;
        }
        if (sub.isChecked()){
            Log.d(LogcatTag, "Operation is sub");
            solution = numone - numtwo;
        }
        if (multiple.isChecked()){
            Log.d(LogcatTag, "Operation is multiple");
            solution = numone * numtwo;
        }
        if (divide.isChecked()){
            Log.d(LogcatTag, "Operation is divide");
            if (numtwo == 0){
                Toast.makeText(this, "Number two Cannot be zero", Toast.LENGTH_SHORT).show();
                return;
            }
            solution = numone / numtwo;
        }
        Log.d(LogcatTag, "the result of operation is:" + solution);

        answer.setText("The answer is" + solution);


        switch ((int) Math.random()*2){
            case 0 : throw new ArithmeticException("i'am generated arithmetical exception");
            case 1 : throw new IOException("i'am generated ioexception exception");
        }

    }
}