package com.example.photoprintsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    int numberPrints;
    double printPrice;
    double printTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final RadioButton radioOne = (RadioButton) findViewById(R.id.size46Radio);
        final RadioButton radioTwo = (RadioButton) findViewById(R.id.size57Radio);
        final RadioButton radioThree = (RadioButton) findViewById(R.id.size810Radio);
        final EditText photoInput = (EditText) findViewById(R.id.picNumTxt);
        final TextView photoOutput = (TextView)findViewById(R.id.orderOutput);
        Button calcPrints = (Button)findViewById(R.id.orderButton);


        calcPrints.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                numberPrints = Integer.parseInt(photoInput.getText().toString());
                if(numberPrints > 50){
                    Toast notify = Toast.makeText(MainActivity.this,"Number of prints must be \nless than 50",Toast.LENGTH_LONG);
                }
                else if(radioOne.isChecked()){
                    printPrice = 0.19;
                    printTotal = printPrice * numberPrints;
                    DecimalFormat currency = new DecimalFormat("$###,###.##");
                    photoOutput.setText(currency.format(printTotal));

                }
                else if(radioTwo.isChecked()){
                    printPrice = 0.49;
                    printTotal = printPrice * numberPrints;
                    DecimalFormat currency = new DecimalFormat("$###,###.##");
                    photoOutput.setText(currency.format(printTotal));
                }
                else if(radioThree.isChecked()){
                    printPrice = 0.79;
                    printTotal = printPrice * numberPrints;
                    DecimalFormat currency = new DecimalFormat("$###,###.##");
                    photoOutput.setText(currency.format(printTotal));
                }
            }

        });


    }
}
