package com.example.rocafellabob.fittigerlife.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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
 */
public class CaloriesActivity extends AppCompatActivity implements RecordActivity, UIInterface {

    EditText caloriesEntered;
    TextView caloriesReturned;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories);
        loadElements();
    }

    @Override
    public void loadElements() {
        caloriesEntered = (EditText) findViewById(R.id.caloriesEntered);
        caloriesReturned = (TextView) findViewById(R.id.CaloriesOutput);
    }

    @Override
    public void record(View view) {
        String caloriesFinalString = caloriesEntered.getText().toString();

        String date = sdf.format(new Date());

        Data.recordData(this, calories_csv, new String[]{date, caloriesFinalString});
        List<String[]> data = Data.readData(this, calories_csv);
        int calorieTotal = 0;
        for (String[] s : data) { // for every entry in data, find entries that match the date and add em up
            if (s[0].equals(date)) {
                calorieTotal += Integer.parseInt(s[1]);
            }
        }
        caloriesReturned.setText(Integer.toString(calorieTotal));
    }
}
