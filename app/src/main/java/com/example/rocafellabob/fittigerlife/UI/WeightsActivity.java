package com.example.rocafellabob.fittigerlife.UI;

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
import com.example.rocafellabob.fittigerlife.UI.interfaces.RecordActivity;
import com.example.rocafellabob.fittigerlife.data.Data;

/**
 * WeightsActivity.java\ interface people will record their workout data in
 changed: Date: Person: Reason: 10/25/16 Spencer Update the spinner class to
 show options 11/11/16 Spencer Update it to write to a file 11/15/16 Spencer
 Interface bug fixing
 */
public class WeightsActivity extends AppCompatActivity implements RecordActivity{

    EditText Weights, Reps, Sets;
    final static String file_name =  "weightLiftingStorage.csv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weights);
    }

    public void record(View view) {
        Weights = (EditText) findViewById(R.id.editTextWeight);
        Sets = (EditText) findViewById(R.id.editTextSets);
        Reps = (EditText) findViewById(R.id.editTextReps);
        String WeightFinalString = Weights.getText().toString();
        String SetsFinalString = Sets.getText().toString();
        String RepsFinalString = Reps.getText().toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String date = sdf.format(new Date());
        // date, weight, sets, reps
        Data.recordData(this, file_name, new String[]{date, WeightFinalString, SetsFinalString, RepsFinalString});
        // why not show the stats after every record?
        Intent intent = new Intent(this, ShowWeightLifting.class);
        startActivity(intent);

    }

    // opens another activity that displays things
    public void ShowRecords(View view) {
        Intent intent = new Intent(this, ShowWeightLifting.class);
        startActivity(intent);
    }
}
