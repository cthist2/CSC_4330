package com.example.rocafellabob.fittigerlife.UI;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.rocafellabob.fittigerlife.data.Data;
import com.example.rocafellabob.fittigerlife.UI.interfaces.*;
import static com.example.rocafellabob.fittigerlife.util.DataConsts.*;

import java.util.List;

/**
 * GoalsActivity.java
 * see what your fitness goals are
 * Date:        Person:     Reason:
 * 10/26/16     Spencer     Worked on data inputting and storing 
 * 10/29/16     Spencer     Worked on adding permission to access to internal storage 
 * 10/30/16     Spencer     Fixed the saving internal storage, I believe?
 * 11/16/16     Thomas      move data processing to separate file (huge refactoring)
 */
public class GoalsActivity extends AppCompatActivity implements DisplayActivity, UIInterface {

    TextView Wrist, Waist, Weight, Neck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);
        loadElements();
        load();
    }

    @Override
    public void loadElements() {
        Wrist = (TextView) findViewById(R.id.textWrist);
        Waist = (TextView) findViewById(R.id.textWaiste);
        Weight = (TextView) findViewById(R.id.textWeight);
        Neck = (TextView) findViewById(R.id.textNeck);
    }

    // reload the data when the screen comes back up
    @Override
    protected void onStart() {
        super.onStart();
        load();
    }

    @Override
    public void load() {
        List<String[]> data = Data.readData(this, measurements_csv);
        if (data != null) {
            String[] measurements = data.get(0); // should only have 1 line
            if (measurements.length == 4) { // fml workaround
                Wrist.setText(measurements[0]);
                Waist.setText(measurements[1]);
                Weight.setText(measurements[2]);
                Neck.setText(measurements[3]);
            }
        }
    }

    @Override
    public void load(View view) {
        load();
    }

    /**
     * opens the editgoals activity
     * 
     * @param view the owner of the function call
     */
    public void EditGoal(View view) {
        Intent intent = new Intent(this, EditGoalsActivity.class);
        startActivity(intent);
    }

}
