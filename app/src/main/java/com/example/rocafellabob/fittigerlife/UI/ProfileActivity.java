package com.example.rocafellabob.fittigerlife.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.rocafellabob.fittigerlife.UI.interfaces.*;
import com.example.rocafellabob.fittigerlife.data.Data;
import com.example.rocafellabob.fittigerlife.graphs.GraphView;
import static com.example.rocafellabob.fittigerlife.util.DataConsts.*;

import java.util.List;

/**
 * ProfileActivity.java
 * the summary/profile
 * Date:        Person:     Reason:
 * 11/1/16      Spencer     put data inputting and calculations in. Calculating BMI is now working
 * 11/3/16      Spencer     Added the age parameter and the gender buttons
 * 11/16/16     Thomas      move data processing to separate file (huge refactoring)
 * 11/17/16     Spencer     Did some UI changes to Profile to include measurements
 */
public class ProfileActivity extends AppCompatActivity implements DisplayActivity, UIInterface {

    TextView Weight, Height, Age, BMI, GenderText, Wrist, Waist, Neck;
    String Gender;
    Spinner GraphTypes;

    @Override
    /**
     * @param Bundle savedInstanceState (The save instancestate from the xml file
     * @description: once the activity is called, the activity is created and all functions in oncreate called
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        loadElements();
        load();
    }

    @Override
    /**
     * called by oncreate
     *
     * @param none
     * @description: loads all the xml parts into the java variables
     */
    public void loadElements() {
        GraphTypes = (Spinner) findViewById(R.id.spinner2);
        //BMI = (TextView) findViewById(R.id.BMIDisplay);
        Weight = (TextView) findViewById(R.id.WeightDisplay);
        Height = (TextView) findViewById(R.id.HeightDisplay);
        Age = (TextView) findViewById(R.id.AgeDisplay);
        GenderText = (TextView) findViewById(R.id.GenderDisplay);
        Wrist = (TextView) findViewById(R.id.WristDisplay);
        Waist = (TextView) findViewById(R.id.WaistDisplay);
        Neck = (TextView) findViewById(R.id.NeckDisplay);
    }

    @Override
    protected void onStart() {
        super.onStart();
        load();
    }

    @Override
    /**
     * called by oncreate
     *
     * @param none
     * @description: read data and sets this data to the textviews
     */
    public void load() {
        // weight age height gender
        List<String[]> fc = Data.readData(this, profile_csv);
        if (fc != null) {
            TextView[] tviews = new TextView[]{Weight, Height, Age, GenderText};
            String[] info = fc.get(0);
            // weight age height
            for (int i = 0; i < 4; i++) {
                tviews[i].setText(info[i]);
            }
        }
        List<String[]> fe = Data.readData(this, current_measurements_csv);
        if (fe != null) {
            TextView[] tviews = new TextView[]{Wrist, Neck, Waist};
            String[] info = fe.get(0);
            // weight age height
            for (int i = 0; i < 3; i++) {
                tviews[i].setText(info[i]);
            }
        }
    }
    /**
     * @param View view
     * @description: calls the load activity with new params
     */
    @Override
    public void load(View view) {
        load();
    }

    /**
     * opens the editprofile activity
     *
     * @param view the owner of the function call
     */
    public void editProfile(View view) {
        Intent intent = new Intent(this, EditProfileActivity.class);
        startActivity(intent);
    }
    /**
     * called by button click
     *
     * @param View view
     * @description: starts the activity editMeasurement
     */
    public void editMeasurement(View view) {
        Intent intent = new Intent(this, EditMeasurementsActivity.class);
        startActivity(intent);
    }

    /**
     * creates a graph object to replace the view of this activity
     *
     * @param view the owner of the function call
     */
    public void createGraph(View view) {
        String graphtype = GraphTypes.getSelectedItem().toString();
        double[] mypoints = Data.getData(this, graphtype);
        setContentView(new GraphView(this, mypoints, graphtype));
    }
}
