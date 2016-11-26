
package com.example.rocafellabob.fittigerlife.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rocafellabob.fittigerlife.UI.interfaces.*;
import com.example.rocafellabob.fittigerlife.data.Data;

public class EditMeasurementsActivity extends AppCompatActivity implements EditActivity, UIInterface {
    /**
     * EditMeasurementsActivity.java
     * edit fitness goals activity
     * Date:        Person:     Reason:
     * 11/21/16     Spencer     Used editgoalsActivity as a template to build this
     */
    EditText weight, wrist, neck, waiste;

    @Override
    /**
     * @param Bundle savedInstanceState (The save instancestate from the xml file
     * @description: once the activity is called, the activity is created and all functions in oncreate called
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_measurements);
        loadElements();
    }

    @Override
    /**
     * called by oncreate
     *
     * @param none
     * @description: loads all the xml parts into the java variables
     */
    public void loadElements() {
        wrist = (EditText) findViewById(R.id.editWrist);
        weight = (EditText) findViewById(R.id.editWeight);
        neck = (EditText) findViewById(R.id.EditNeck);
        waiste = (EditText) findViewById(R.id.editWaist);
    }

    @Override
    /**
     * @param View view
     * @description: Updates the data recording and records data user inputs
     */
    public void update(View view) {
        String wristFinalString = wrist.getText().toString();
        String neckFinalString = neck.getText().toString();
        String waistFinalString = waiste.getText().toString();
        // String weightFinalString = weight.getText().toString();
        if(checkFormat(wristFinalString) && checkFormat(neckFinalString) && checkFormat(waistFinalString)) {
            Data.recordGoal(this, wristFinalString, neckFinalString, waistFinalString);
        }
        else {
            Toast.makeText(getApplicationContext(), "Incorrect Input Format (numbers only 0-99999)", Toast.LENGTH_LONG).show();
        }
    }
    /**
     * @param String st (String being checked)
     * @description: Checks to make sure string meets requirements
     */
    @Override
    public boolean checkFormat(String st) {
        return st.matches("^\\d{1,5}$");
    }
}
