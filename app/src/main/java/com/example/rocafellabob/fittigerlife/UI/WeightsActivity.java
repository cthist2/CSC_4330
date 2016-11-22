package com.example.rocafellabob.fittigerlife.UI;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.rocafellabob.fittigerlife.UI.interfaces.*;
import com.example.rocafellabob.fittigerlife.data.Data;
import static com.example.rocafellabob.fittigerlife.util.DataConsts.*;

import java.util.Date;

/**
 * WeightsActivity.java
 * interface people will record their workout data in
 * Date:        Person:     Reason:
 * 10/25/16     Spencer     Update the spinner class to show options 
 * 11/11/16     Spencer     Update it to write to a file 
 * 11/15/16     Spencer     Interface bug fixing
 * 11/16/16     Thomas      move data processing to separate file (huge refactoring)
 * 11/22/16     Thomas      added function to check format of input
 */
public class WeightsActivity extends AppCompatActivity implements RecordActivity, UIInterface {

    EditText Weights, Reps, Sets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weights);
        loadElements();
    }

    @Override
    public void record(View view) {
        // deleteFile(weights_csv);
        String WeightFinalString = Weights.getText().toString();
        String SetsFinalString = Sets.getText().toString();
        String RepsFinalString = Reps.getText().toString();
        String date = sdf.format(new Date());
        // date, weight, sets, reps
        if (checkFormat(WeightFinalString) && checkFormat(SetsFinalString) && checkFormat(RepsFinalString)) {
            Data.recordData(this, weights_csv, new String[]{date, WeightFinalString, SetsFinalString, RepsFinalString});
        } else {
            Toast.makeText(getApplicationContext(), "Incorrect Input Format (numbers only 0-99999(", Toast.LENGTH_LONG).show();
        }

    }
    // why not show the stats after every record?
    //  Intent intent = new Intent(this, ShowWeightLifting.class);
    // startActivity(intent);

    /**
     * opens the showweightlifting activity
     *
     * @param view the owner of the function call
     */
    public void ShowRecords(View view) {

        Intent intent = new Intent(this, ShowWeightLifting.class);
        startActivity(intent);
    }

    @Override
    public void loadElements() {
        Weights = (EditText) findViewById(R.id.editTextWeight);
        Sets = (EditText) findViewById(R.id.editTextSets);
        Reps = (EditText) findViewById(R.id.editTextReps);
    }

    @Override
    public boolean checkFormat(String st) {
        return st.matches("^\\d{1,5}$"); // allow only numbers, up to 5 digits
    }
}
