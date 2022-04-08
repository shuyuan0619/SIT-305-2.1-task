package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    public int flag = 0;
    public Spinner spinner;
    public EditText editText;
    public TextView textView1;
    public TextView textView2;
    public TextView textView3;
    public ImageButton imageButton1;
    public ImageButton imageButton2;
    public ImageButton imageButton3;
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spin);
        imageButton1 = findViewById(R.id.cm);
        imageButton2 = findViewById(R.id.te);
        imageButton3 = findViewById(R.id.we);
        editText = findViewById(R.id.content);
        textView1 = findViewById(R.id.text1);
        textView2 = findViewById(R.id.text2);
        textView3 = findViewById(R.id.text3);
        textView1.setVisibility(View.INVISIBLE);
        textView2.setVisibility(View.INVISIBLE);
        textView3.setVisibility(View.INVISIBLE);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                flag = position;
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                if(flag==0){
                    String string = editText.getText().toString();
                    Double value = Double.valueOf(string);
                    Double centimetre = doMath(value * 100);
                    Double foot = doMath(value * 3.2808);
                    Double inch = doMath(value * 39.3700);
                    textView1.setText(DecimalFormat("0.00").format(centimetre)+"  Centimetre");
                    textView2.setText(DecimalFormat("0.00").format(foot)+"  Foot");
                    textView3.setText(DecimalFormat("0.00").format(inch)+"  Inch");
                    textView1.setVisibility(View.VISIBLE);
                    textView2.setVisibility(View.VISIBLE);

                    textView3.setVisibility(View.VISIBLE);
                }else{
                    Toast.makeText(MainActivity.this, "input icon wrong", 2000).show();
                }
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                if(flag==1){
                    String string = editText.getText().toString();
                    Double value = Double.valueOf(string);
                    Double fahrenheit = doMath((value * 9/5) + 32);
                    Double kelvin = doMath(value + 273.15);
                    textView1.setText(DecimalFormat("0.00").format(fahrenheit)+" Fahrenheit");
                    textView2.setText(DecimalFormat("0.00").format(kelvin)+" Kelvin");
                    textView1.setVisibility(View.VISIBLE);
                    textView2.setVisibility(View.VISIBLE);
                    textView3.setVisibility(View.INVISIBLE);
                }else{
                    Toast.makeText(MainActivity.this, "input icon wrong", 2000).show();
                }
            }
        });
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                if(flag==2){
                    String string = editText.getText().toString();
                    Double value = Double.valueOf(string);

                    Double grams = doMath(value * 1000);
                    Double ounce = doMath(value * 35.274);
                    Double pound = doMath(value * 2.2046);
                    textView1.setText(DecimalFormat("0.00").format(grams)+" Gram");
                    textView2.setText(DecimalFormat("0.00").format(ounce)+" Ounce(Oz)");
                    textView3.setText(DecimalFormat("0.00").format(pound)+" Pound(lb)");

                    textView1.setVisibility(View.VISIBLE);
                    textView2.setVisibility(View.VISIBLE);
                    textView3.setVisibility(View.VISIBLE);
                }else{
                    Toast.makeText(MainActivity.this, "input icon wrong", 2000).show();
                }
            }
        });

    }
    double doMath(double num){
        int temp = (int)(num * 100 + 0.5);
        double result = temp/100.00;
        return result;
    }

}
