package com.example.bmi2;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    Button button,button2,button3;
    EditText editTxt1,editTxt2,editFeet,editInch;
    TextView textView,textView2;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        editTxt1 = findViewById(R.id.editTxt1);
        editTxt2 = findViewById(R.id.editTxt2);
        editFeet = findViewById(R.id.editFeet);
        editInch = findViewById(R.id.editInch);
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        button2.setBackgroundColor(Color.DKGRAY);
        button2.setTextColor(Color.WHITE);
        button.setBackgroundColor(Color.DKGRAY);
        button.setTextColor(Color.WHITE);
        button3.setBackgroundColor(Color.DKGRAY);
        button3.setTextColor(Color.WHITE);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String feet = (editFeet.getText().toString());
                String inch = (editInch.getText().toString());

                if(TextUtils.isEmpty(feet))
                {
                    editFeet.setError("Please enter your feet");
                    editFeet.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(inch))
                {
                    editInch.setError("Please enter your inch");
                    editInch.requestFocus();
                    return;
                }
                double Feet1 = Double.parseDouble(feet)*30.48;
                double Inch1 = Double.parseDouble(inch)*2.54;
                double Convert = Feet1+Inch1;
                double result = (double)(Math.round(Convert*100))/100.0;

                textView2.setText(Double.toString(result) + "cm");
                editTxt2.setText(Double.toString(result));
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String W = (editTxt1.getText().toString());
                String H = (editTxt2.getText().toString());
                if (TextUtils.isEmpty(W)) {
                    editTxt1.setError("Please enter your weight");
                    editFeet.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(H)) {
                    editTxt2.setError("Please enter your height");
                    editInch.requestFocus();
                    return;
                }
                double weight = Double.parseDouble(W);
                double height = Double.parseDouble(H)*0.01;
                double newHeight = height*height;

                double Bmi = (weight/newHeight);
                double Index = (double)( Math.round(Bmi * 100)) /100.0;
                textView.setText("BMI = " + Double.toString(Index));
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editFeet.setText("");
                editInch.setText("");
                textView2.setText("");
                editTxt1.setText("");
                editTxt2.setText("");
                textView.setText("");
            }
        }); }
}
