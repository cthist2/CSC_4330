package com.example.rocafellabob.fittigerlife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * setProfileActivity.java\
 * interface people will record their goal data in
 * changed:
 * Date:        Person:     Reason:
 * 11/1/16    Spencer     put data inputting and calculations in. Calculating BMI is now working.
 * 11/3/16      Spencer     Added the age parameter aand the gender buttons
 * 11/6/16      Spencer     Back end recording changes to how data will display
 */

public class setProfileActivity extends AppCompatActivity {
    EditText Weight, Height,Age;
    TextView BMI;
    String Gender;
    @Override
    /**
     * When activities called, aka when the button is pressed, starts the timer
     *
     * @return Nothing
     * @param Bundle savedInstanceState
     *  Creates the activity, and loads the base things into it
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_profile);

        BMI = (TextView)findViewById(R.id.BMI);
        Weight = (EditText) findViewById(R.id.editWeight);
        Height = (EditText) findViewById(R.id.editHeight);
        Age    = (EditText) findViewById(R.id.editAge);
    }
    /**
     * Loads information into the csv file
     *
     * @return Nothing
     * @param View view
     *  Loads info into file
     */
    public void writeMessage(View view) {
        double WeightFinal = Double.parseDouble(Weight.getText().toString());
        double AgeFinal = Double.parseDouble(Age.getText().toString());
        double HeightFinal = Double.parseDouble(Height.getText().toString());
        String WeightFinalString = Weight.getText().toString();
        String HeightFinalString = Height.getText().toString();
        String AgeFinalString = Age.getText().toString();
        HeightFinal = HeightFinal /12;
        String Comma = ",";
        String Period = ".";
        String file_name = "Profile.csv";
        double BMIfinal = (WeightFinal * 4.88)/(HeightFinal*HeightFinal);
        String BMIFinalString= Double.toString(BMIfinal);
        try {
            FileOutputStream fileOutputStream = openFileOutput(file_name, MODE_PRIVATE);
            fileOutputStream.write(WeightFinalString.getBytes());
            fileOutputStream.write(Comma.getBytes());
            fileOutputStream.write(HeightFinalString.getBytes());
            fileOutputStream.write(Comma.getBytes());
            fileOutputStream.write(AgeFinalString.getBytes());
            fileOutputStream.write(Comma.getBytes());
            fileOutputStream.write(Gender.getBytes());
            fileOutputStream.write(Period.getBytes());
            fileOutputStream.close();
            Toast.makeText(getApplicationContext(), "Data Stored", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BMI.setText(BMIFinalString);
    }
    /**
     * Loads information into the csv file
     *
     * @return Nothing
     * @param View view
     *  Sets gender to male if button click
     */
    public void Male(View view)
    {
        Gender = "Male";
    }
    /**
     * Loads information into the csv file
     *
     * @return Nothing
     * @param View view
     *  Sets gender to female if button is click.
     */
    public void Female(View view)
    {
        Gender = "Female";
    }
}


