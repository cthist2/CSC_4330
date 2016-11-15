package com.example.rocafellabob.fittigerlife;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

/**
 * moveExerciseActivity.java\
 * interface people will record their workout data in
 * changed:
 * Date:        Person:     Reason:
 *  10/25/16    Spencer     Update the spinner class to show options
 *  11/11/16    Spencer     Update it to write to a file
 */
public class moveExerciseActivity extends AppCompatActivity {
    private Spinner spinner1;
    EditText Weights, Reps, Sets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_exercise);
    }
    public void SaveData(View view) {
        Weights= (EditText)findViewById(R.id.editTextWeight);
        Sets= (EditText)findViewById(R.id.editTextSets);
        Reps= (EditText)findViewById(R.id.editTextReps);
        String WeightFinalString = Weights.getText().toString();
        String SetsFinalString = Sets.getText().toString();
        String RepsFinalString = Reps.getText().toString();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM MM dd, yyyy");
        long date = System.currentTimeMillis();
        String dateString = sdf.format(date);
        String Comma = ",";
        String Period = ".";
        String file_name = "weightLiftingStorage.csv";
        try {
            FileOutputStream fileOutputStream = openFileOutput(file_name, MODE_PRIVATE);
            fileOutputStream.write(dateString.getBytes());
            fileOutputStream.write(Comma.getBytes());
            fileOutputStream.write(WeightFinalString.getBytes());
            fileOutputStream.write(Comma.getBytes());
            fileOutputStream.write(SetsFinalString.getBytes());
            fileOutputStream.write(Comma.getBytes());
            fileOutputStream.write(RepsFinalString.getBytes());
            fileOutputStream.write(Period.getBytes());
            fileOutputStream.close();
            //this will store values then the date of them.
            Toast.makeText(getApplicationContext(), "Data Stored", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }


<<<<<<< HEAD
}
=======

    }
    public void ShowRecords(View view) {
        Intent intent = new Intent(this,ShowWeightLifting.class);
        startActivity(intent);
    }
    }
>>>>>>> refs/remotes/origin/master



