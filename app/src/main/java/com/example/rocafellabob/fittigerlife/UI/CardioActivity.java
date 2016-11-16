package com.example.rocafellabob.fittigerlife.UI;

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
import com.example.rocafellabob.fittigerlife.UI.interfaces.RecordActivity;
import com.example.rocafellabob.fittigerlife.data.Data;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * CardioActivity.java\ interface people will record their workout data in
 * changed: Date: Person: Reason: 11/4/16 Spencer Put basic Ui 11/5/16 Spencer
 * Did more Ui work and fixed chronometer to time correctly. 11/8/16 Spencer Did
 * back end changes to data storing
 */
public class CardioActivity extends AppCompatActivity implements RecordActivity{

    final static String file_name =  "Cardio.csv";
    private Spinner spinner;
    Chronometer Chrono;
    Button StartTimer, pauseTimer, resetTimer, recordToFile;
    EditText inputTime;

    @Override
    /**
     * When activities called, aka when the button is pressed, it creates the
     * activity
     *
     * @return Nothing
     * @param Bundle savedInstanceState, basically meaning passing the state
     * from the other activity that called it
     *
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio);
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
     * @return Nothing
     * @param View view Starts the chronometer timer
     */
    public void startChronometer(View view) {
        Chrono.start();
    }

    /**
     * When activities called, aka when the button is pressed, starts the timer
     *
     * @return Nothing
     * @param View view Stops the chronometer timer
     */
    public void stopChronometer(View view) {
        Chrono.stop();
    }

    /**
     * When activities called, aka when the button is pressed, starts the timer
     *
     * @return Nothing
     * @param View view Reset the chronometer timer
     */
    public void resetChronometer(View view) {
        Chrono.setBase(SystemClock.elapsedRealtime());
    }

    /**
     * When activities called, aka when the button is pressed, starts the timer
     *
     * @return Nothing
     * @param View view Records the data to a csv file.
     */
    public void record(View view) {
        String activityFinal = spinner.getSelectedItem().toString();
        String inputTimeFinal = inputTime.getText().toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String date = sdf.format(new Date());
        Data.recordData(this, file_name, new String[]{date, activityFinal, inputTimeFinal});
    }
}
