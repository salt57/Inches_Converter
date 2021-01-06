package com.sourishgupta.inches_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText inchesText;
    private Button calculateButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setupOnClickListener();
    }

    private void findViews() {
        inchesText = findViewById(R.id.edit_text_inches);
        calculateButton = findViewById(R.id.button_calculate);
        resultText = findViewById(R.id.text_view_result);
    }

    private void setupOnClickListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inchesText.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter a value", Toast.LENGTH_SHORT).show();
                } else{
                    displayResult(convertToMeters());
                }
            }
        });
    }

    private double convertToMeters() {
        return Double.parseDouble(inchesText.getText().toString()) * 0.0254;
    }

    private void displayResult(double meters) {
        DecimalFormat formatter = new DecimalFormat("0.00");
        String finalResultText = formatter.format(meters) + " meters";
        resultText.setText(finalResultText);
    }
}