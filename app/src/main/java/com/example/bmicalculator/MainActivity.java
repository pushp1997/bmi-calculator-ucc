package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText weight;
    private EditText height;
    private TextView output;
    private ProgressBar bmiScale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        bmiScale = findViewById(R.id.bmiScale);
        output = findViewById(R.id.output);
    }

    public void onCalculateClick(View v){
        float weightValue = Float.parseFloat(weight.getText().toString());
        float heightValue = Float.parseFloat(height.getText().toString());
        double bmiValue = weightValue/Math.pow(heightValue/100, 2);

        bmiScale.setProgress((int)bmiValue);

        if (bmiValue < 18.5){
            output.setText(R.string.underweightString);
        }
        else if (bmiValue >= 18.5 && bmiValue < 25){
            output.setText(R.string.normalWeightString);
        }
        else if (bmiValue >= 25 && bmiValue < 30){
            output.setText(R.string.overweightString);
        }
        else{
            output.setText(R.string.obeseString);
        }
        output.setVisibility(View.VISIBLE);
    }
}