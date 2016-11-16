package com.example.rocafellabob.fittigerlife;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.rocafellabob.fittigerlife.data.Data;

/**
 * moveExerciseActivity.java\ interface people will record their workout data in
 * changed: Date: Person: Reason: 10/25/16 Spencer Update the spinner class to
 * show options 11/11/16 Spencer Update it to write to a file 11/15/16 Spencer
 * Interface bug fixing
 */
public class moveExerciseActivity extends AppCompatActivity {

    private Spinner spinner1;
    EditText Weights, Reps, Sets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_exercise);
    }

    /**
     * Creates the recordCalories Method
     *
     * @return sorted module
     * @param View view View data and displays it. this just clears the text
     * fields when someone clicks on it
     */
    /* public void click(View view)
    {
        Weights= (EditText)findViewById(R.id.editTextWeight);
        Sets= (EditText)findViewById(R.id.editTextSets);
        Reps= (EditText)findViewById(R.id.editTextReps);
        Weights.setText("");
        Sets.setText("");
        Reps.setText("");
    }*/
    public void SaveData(View view) {
        Weights = (EditText) findViewById(R.id.editTextWeight);
        Sets = (EditText) findViewById(R.id.editTextSets);
        Reps = (EditText) findViewById(R.id.editTextReps);
        String WeightFinalString = Weights.getText().toString();
        String SetsFinalString = Sets.getText().toString();
        String RepsFinalString = Reps.getText().toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String date = sdf.format(new Date());
        // date, weight, sets, reps
        Data.recordData(this, "weightLiftingStorage.csv", new String[]{date, WeightFinalString, SetsFinalString, RepsFinalString});

    }

    public void ShowRecords(View view) {
        Intent intent = new Intent(this, ShowWeightLifting.class);
        startActivity(intent);
    }
}
