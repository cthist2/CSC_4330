package com.example.rocafellabob.fittigerlife.UI;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.Toast;

import com.example.rocafellabob.fittigerlife.UI.interfaces.*;
import com.example.rocafellabob.fittigerlife.data.Data;
import static com.example.rocafellabob.fittigerlife.util.DataConsts.*;

import java.util.Date;

/**
 * CardioActivity.java
 * interface people will record their workout data in
 * changed:
 * Date:        Person:     Reason:
 *  11/4/16     Spencer     Put basic Ui
 *  11/5/16     Spencer     Did more Ui work and fixed chronometer to time correctly
 *  11/8/16     Spencer     Did back end changes to data storing
 *  11/16/16     Thomas      move data processing to separate file (huge refactoring)
 *  11/22/16     Thomas      added function to check format of input, recording format to seconds
 */
public class CardioActivity extends AppCompatActivity implements RecordActivity, UIInterface {

    private long lastPause;
    private Spinner spinner;
    Chronometer Chrono;
    Button StartTimer, pauseTimer, resetTimer, recordToFile;
    EditText inputTime, datefield;
    /**
     * @param Bundle savedInstanceState (The save instancestate from the xml file
     * @description: once the activity is called, the activity is created and all functions in oncreate called
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio);
        loadElements();
        Chrono.setBase(SystemClock.elapsedRealtime() + 3000); // 3 second 'delay' until start
        Chrono.start();
    }

    @Override
    /**
     * called by oncreate
     *
     * @param none
     * @description: loads all the xml parts into the java variables
     */
    public void loadElements() {
        StartTimer = (Button) findViewById(R.id.StartTimer);
        pauseTimer = (Button) findViewById(R.id.stopButton);
        resetTimer = (Button) findViewById(R.id.resetButton);
        Chrono = (Chronometer) findViewById(R.id.chronometerFinal);
        inputTime = (EditText) findViewById(R.id.timeEntry);
        spinner = (Spinner) findViewById(R.id.spinner);
        datefield = (EditText) findViewById(R.id.editText2);

    }

    /**
     * When activities called, aka when the button is pressed, starts the timer
     *
     * @param view the owner of the function call
     */
    public void startChronometer(View view) {
        Chrono.setBase(Chrono.getBase() + SystemClock.elapsedRealtime() - lastPause);
        Chrono.start();
    }

    /**
     * When activities called, aka when the button is pressed, stops the timer
     *
     * @param view the owner of the function call
     */
    public void stopChronometer(View view) {
        lastPause = SystemClock.elapsedRealtime();
        Chrono.stop();
        // also update the input time
        inputTime.setText(Long.toString((SystemClock.elapsedRealtime() - Chrono.getBase()) / 1000));
    }

    /**
     * When activities called, aka when the button is pressed, resets the timer
     *
     * @return Nothing
     * @param view the owner of the function call
     */
    public void resetChronometer(View view) {
        lastPause = 0;
        Chrono.setBase(SystemClock.elapsedRealtime() + 3000); // 3 second 'delay' until start
    }

    @Override
    /**
     * opens when button is clicked
     *
     * @param View view pulls the activity view
     *             Saves data to text file and checks to make sure it fits the constraints
     */
    public void record(View view) {
        String activityFinal = spinner.getSelectedItem().toString();
        String inputTimeFinal = inputTime.getText().toString();
//        String date = sdf.format(new Date());
        String date = datefield.getText().toString();
        if (checkFormat(inputTimeFinal)) {
            Data.recordData(this, cardio_csv, new String[]{date, activityFinal, inputTimeFinal});
        } else {
            Toast.makeText(getApplicationContext(), "Incorrect Input Format (numbers only 0-99999)", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * opens the cardio activity screen
     *
     * @param view the owner of the function call
     */
    public void load(View view) {
        Intent intent = new Intent(this, ShowCardioActivity.class);
        startActivity(intent);
    }

    @Override
    /**
     * @param String st (String being checked)
     * @description: Checks to make sure string meets requirements
     */
    public boolean checkFormat(String st) {
        return st.matches("^\\d{1,5}$"); // allow only numbers, up to 5 digits
    }
}
