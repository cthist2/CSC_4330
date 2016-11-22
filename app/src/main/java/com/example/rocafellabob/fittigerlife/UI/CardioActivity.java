package com.example.rocafellabob.fittigerlife.UI;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Button;

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
 */
public class CardioActivity extends AppCompatActivity implements RecordActivity, UIInterface {

    private Spinner spinner;
    Chronometer Chrono;
    Button StartTimer, pauseTimer, resetTimer, recordToFile;
    EditText inputTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio);
        loadElements();
    }

    @Override
    public void loadElements() {
        StartTimer = (Button) findViewById(R.id.StartTimer);
        pauseTimer = (Button) findViewById(R.id.stopButton);
        resetTimer = (Button) findViewById(R.id.resetButton);
        Chrono = (Chronometer) findViewById(R.id.chronometerFinal);
        inputTime = (EditText) findViewById(R.id.timeEntry);
        spinner = (Spinner) findViewById(R.id.spinner);
    }

    /**
     * When activities called, aka when the button is pressed, starts the timer
     *
     * @param view the owner of the function call
     */
    public void startChronometer(View view) {
        Chrono.start();
    }

    /**
     * When activities called, aka when the button is pressed, stops the timer
     *
     * @param view the owner of the function call
     */
    public void stopChronometer(View view) {
        Chrono.stop();
    }

    /**
     * When activities called, aka when the button is pressed, resets the timer
     *
     * @return Nothing
     * @param view the owner of the function call
     */
    public void resetChronometer(View view) {
        Chrono.setBase(SystemClock.elapsedRealtime());
    }

    public void record(View view) {
        String activityFinal = spinner.getSelectedItem().toString();
        String inputTimeFinal = inputTime.getText().toString();
        String date = sdf.format(new Date());
        Data.recordData(this, cardio_csv, new String[]{date, activityFinal, inputTimeFinal});
    }
    public void load(View view) {
        String activityFinal = spinner.getSelectedItem().toString();
        String inputTimeFinal = inputTime.getText().toString();
        String date = sdf.format(new Date());
        Data.recordData(this, cardio_csv, new String[]{date, activityFinal, inputTimeFinal});
    }
}
