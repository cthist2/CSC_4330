package com.example.rocafellabob.fittigerlife.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rocafellabob.fittigerlife.UI.interfaces.*;
import com.example.rocafellabob.fittigerlife.data.Data;

/**
 * EditProfileActivity.java
 * edit profile activity
 * Date:        Person:     Reason:
 * 11/1/16      Spencer     put data inputting and calculations in. Calculating BMI is now working
 * 11/3/16      Spencer     Added the age parameter and the gender buttons
 * 11/16/16     Thomas      move data processing to separate file (huge refactoring)
 */
public class EditProfileActivity extends AppCompatActivity implements EditActivity, UIInterface {

    EditText Weight, Height, Age;
    TextView BMI;
    String Gender;
    /**
     * @param Bundle savedInstanceState (The save instancestate from the xml file
     * @description: once the activity is called, the activity is created and all functions in oncreate called
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        loadElements();
    }

    @Override
    /**
     * called by oncreate
     *
     * @param none
     * @description: loads all the xml parts into the java variables
     */
    public void loadElements() {
        BMI = (TextView) findViewById(R.id.BMI);
        Weight = (EditText) findViewById(R.id.editWeight);
        Height = (EditText) findViewById(R.id.editHeight);
        Age = (EditText) findViewById(R.id.editAge);
    }

    @Override
    /**
     * @param View view
     * @description: Updates the data recording and records data user inputs
     */
    public void update(View view) {
        String WeightFinalString = Weight.getText().toString();
        String HeightFinalString = Height.getText().toString();
        String AgeFinalString = Age.getText().toString();
        if (checkFormat(WeightFinalString) && checkFormat(HeightFinalString) && checkFormat(AgeFinalString) && Gender != null) {
            double BMIval = Data.recordProfileData(this, WeightFinalString, AgeFinalString, HeightFinalString, Gender);
            BMI.setText(Double.toString(BMIval));
        } else {
            if(Gender == null) {
                Toast.makeText(getApplicationContext(), "Your forgot to pick a gender", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Incorrect Input Format (numbers only 0-99999)", Toast.LENGTH_LONG).show();
            }
        }
    }

    /**
     * changes the saved string to male
     * 
     * @param view the owner of the function call
     */
    public void Male(View view) {
        Gender = "Male";
    }

    /**
     * changes the saved string to female
     * 
     * @param view the owner of the function call
     */
    public void Female(View view) {
        Gender = "Female";
    }
    /**
     * @param String st (String being checked)
     * @description: Checks to make sure string meets requirements
     */
    @Override
    public boolean checkFormat(String st) {
        return st.matches("^\\d{1,5}$");
    }

}
