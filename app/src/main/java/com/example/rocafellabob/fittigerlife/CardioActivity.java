package com.example.rocafellabob.fittigerlife;

import android.os.SystemClock;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.rocafellabob.fittigerlife.data.Data;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * CardioActivity.java\
 * interface people will record their workout data in
 * changed:
 * Date:        Person:     Reason:
 *  11/4/16     Spencer     Put basic Ui
 *  11/5/16     Spencer     Did more Ui work and fixed chronometer to time correctly.
 */
public class CardioActivity extends AppCompatActivity {
    private Spinner spinner2;
    Chronometer Chrono;
    Button StartTimer, pauseTimer, resetTimer, recordToFile;
    EditText inputTime;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio);
        StartTimer=(Button)findViewById(R.id.StartTimer);
        pauseTimer=(Button)findViewById(R.id.stopButton);
        resetTimer=(Button)findViewById(R.id.resetButton);
        Chrono = (Chronometer)findViewById(R.id.chronometerFinal);
        inputTime = (EditText)findViewById(R.id.timeEntry);
        spinner2 = (Spinner)findViewById(R.id.spinner);
    }
    
    public void startChronometer(View view) {
        Chrono.start();
    }
    
    public void stopChronometer(View view)
    {
        Chrono.stop();
    }
    
    public void resetChronometer(View view)
    {
        Chrono.setBase(SystemClock.elapsedRealtime());
    }

    public void submitToFile(View view)
    {


        String activityFinal = spinner2.getSelectedItem().toString();
        String inputTimeFinal = inputTime.getText().toString();
        Data.recordCardioData(this, activityFinal, inputTimeFinal, "somedate");
        /*
        String Comma = ",";
        String Period = ".";
        String file_name = "Cardio.csv";
        try {
            FileOutputStream fileOutputStream = openFileOutput(file_name, MODE_PRIVATE);
            fileOutputStream.write(activityFinal.getBytes());
            fileOutputStream.write(Comma.getBytes());
            fileOutputStream.write(inputTimeFinal.getBytes());
            fileOutputStream.write(Period.getBytes());
            fileOutputStream.close();
            Toast.makeText(getApplicationContext(), "Data Stored", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */


    }
}
