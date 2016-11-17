package com.example.rocafellabob.fittigerlife.UI;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.rocafellabob.fittigerlife.UI.interfaces.*;
import com.example.rocafellabob.fittigerlife.data.Data;
import static com.example.rocafellabob.fittigerlife.util.DataConsts.*;

import java.util.Date;

/**
 * WeightsActivity.java\ interface people will record their workout data in
 changed: Date: Person: Reason: 10/25/16 Spencer Update the spinner class to
 show options 11/11/16 Spencer Update it to write to a file 11/15/16 Spencer
 Interface bug fixing
 */
public class WeightsActivity extends AppCompatActivity implements RecordActivity, UIInterface{

    EditText Weights, Reps, Sets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weights);
        loadElements();
    }

    
    public void record(View view) {
        String WeightFinalString = Weights.getText().toString();
        String SetsFinalString = Sets.getText().toString();
        String RepsFinalString = Reps.getText().toString();
        String date = sdf.format(new Date());
        // date, weight, sets, reps
        Data.recordData(this, weights_csv, new String[]{date, WeightFinalString, SetsFinalString, RepsFinalString});
        // why not show the stats after every record?
        Intent intent = new Intent(this, ShowWeightLifting.class);
        startActivity(intent);

    }

    // opens another activity that displays things
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
}
