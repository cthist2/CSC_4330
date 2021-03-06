package com.example.rocafellabob.fittigerlife.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rocafellabob.fittigerlife.UI.interfaces.*;
import com.example.rocafellabob.fittigerlife.data.Data;
import static com.example.rocafellabob.fittigerlife.util.DataConsts.*;

import java.util.Date;
import java.util.List;

/**
 * CaloriesActivity.java
 * For recording calories and adding them up changed:
 * Date:        Person:     Reason:
 * 11/1/16      Spencer     Added UI to Xml, put data inputting to file and worked on date function
 * 11/13/16     Spencer     Worked on the storing of the calories 
 * 11/14/16     Spencer     fixed calories counter
 * 11/16/16     Thomas      move data processing to separate file (huge refactoring)
 * 11/17/16     Spencer     Added a text view to be change for daily calories
 * 11/22/16     Thomas      added function to check format of input
 */
public class CaloriesActivity extends AppCompatActivity implements RecordActivity, UIInterface {

    EditText caloriesEntered;
    TextView caloriesReturned;

    @Override
    /**
     * @param Bundle savedInstanceState (The save instancestate from the xml file
     * @description: once the activity is called, the activity is created and all functions in oncreate called
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories);
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
        caloriesEntered = (EditText) findViewById(R.id.caloriesEntered);
        caloriesReturned = (TextView) findViewById(R.id.CaloriesOutput);
    }

    @Override
    /**
     * opens when button is clicked
     *
     * @param View view pulls the activity view
     * @description: Saves data to text file and checks to make sure it fits the constraints
     */
    public void record(View view) {
        String caloriesFinalString = caloriesEntered.getText().toString();

        String date = sdf.format(new Date());

        if (checkFormat(caloriesFinalString)) {
            Data.recordData(this, calories_csv, new String[]{date, caloriesFinalString});
            List<String[]> data = Data.readData(this, calories_csv);
            int calorieTotal = 0;
            for (String[] s : data) { // for every entry in data, find entries that match the date and add em up
                if (s[0].equals(date)) {
                    calorieTotal += Integer.parseInt(s[1]);
                }
            }
            caloriesReturned.setText(Integer.toString(calorieTotal));
        } else {
            Toast.makeText(getApplicationContext(), "Incorrect Input Format (numbers only 0-99999)", Toast.LENGTH_LONG).show();
        }

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
