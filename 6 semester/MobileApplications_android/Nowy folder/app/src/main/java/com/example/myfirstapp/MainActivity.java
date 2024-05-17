package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    TextInputLayout aTextField;
    TextInputLayout bTextField;

    Button biggestCommonDenominator;
    Button leastCommonMultiple;

    TextView result;

    ImageView imageView;
    private int currentImageNumber = 1;
    private final int imageCount = 11;

    View.OnClickListener calculateBiggestCommonDenominator = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                int a = Integer.parseInt
                        (String.valueOf(Objects.requireNonNull(aTextField.getEditText()).getText()));
                int b = Integer.parseInt
                        (String.valueOf(Objects.requireNonNull(bTextField.getEditText()).getText()));

                String val = String.valueOf(BiggestCommonDenominator.calculate(a, b));
                result.setText(val);

            } catch (Exception e) {
                result.setText("Wrong data input");
            }
        }
    };

    View.OnClickListener calculateLeastCommonMultiple = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            try {
                int a = Integer.parseInt
                        (String.valueOf(Objects.requireNonNull(aTextField.getEditText()).getText()));
                int b = Integer.parseInt
                        (String.valueOf(Objects.requireNonNull(bTextField.getEditText()).getText()));

                String val = String.valueOf(LeastCommonMultiple.calculate(a, b));
                result.setText(val);

            } catch (Exception e) {
                result.setText("Wrong data input");
            }
        }
    };

    View.OnClickListener changeImage = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            currentImageNumber = currentImageNumber%imageCount;
            currentImageNumber++;
            String resourceName = "facet" + currentImageNumber;
            int resourceId = getResources().getIdentifier(resourceName, "drawable", getPackageName());
            imageView.setImageResource(resourceId);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.aTextField = findViewById(R.id.aInput);
        this.bTextField = findViewById(R.id.bInput);
        this.result = findViewById(R.id.result);

        this.leastCommonMultiple = findViewById(R.id.leastCommonMultiple);
        this.leastCommonMultiple.setOnClickListener(calculateLeastCommonMultiple);

        this.biggestCommonDenominator = findViewById(R.id.biggestCommonDenominator);
        this.biggestCommonDenominator.setOnClickListener(calculateBiggestCommonDenominator);

        this.imageView = findViewById(R.id.imageView);
        this.imageView.setOnClickListener(changeImage);

    }
}