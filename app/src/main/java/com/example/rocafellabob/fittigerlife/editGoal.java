package com.example.rocafellabob.fittigerlife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.rocafellabob.fittigerlife.data.Data;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * editGoal.java\ back end used to store and edit data changed: Date: Person:
 * Reason: 11/8/16 Spencer First edition changes to Storage 11/11/16 Spencer
 * Fixed storage and insure correct recording
 */
public class editGoal extends AppCompatActivity {

    EditText weight, wrist, neck, waiste;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_goal);
        wrist = (EditText) findViewById(R.id.editWrist);
        weight = (EditText) findViewById(R.id.editWeight);
        neck = (EditText) findViewById(R.id.EditNeck);
        waiste = (EditText) findViewById(R.id.editWaist);
    }

    /**
     * Creates the storeData method
     *
     * @return sorted module
     * @param Stores the data into a csv
     */
    public void storeData(View view) {
        // deleteFile("Measurement.csv");

        String wristFinalString = wrist.getText().toString();
        String neckFinalString = neck.getText().toString();
        String waistFinalString = waiste.getText().toString();
        String weightFinalString = weight.getText().toString();
        Data.recordGoal(this, wristFinalString, neckFinalString, waistFinalString, weightFinalString);
    }
}
