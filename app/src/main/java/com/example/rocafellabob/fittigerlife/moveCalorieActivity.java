package com.example.rocafellabob.fittigerlife;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
/**
 * moveCalorieActivity.java\
 * For recording calories and adding them up
 * changed:
 * Date:        Person:     Reason:
 * 11/1/16    Spencer     Added UI to Xml, put data inputting to file and worked on date function.
 */
public class moveCalorieActivity extends AppCompatActivity {
EditText caloriesEntered;
TextView Test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_calorie);
        caloriesEntered = (EditText) findViewById(R.id.caloriesEntered);

    }

    public void recordCalories(View view) {
       Test= (TextView)findViewById(R.id.Test);
        String Message1 = caloriesEntered.getText().toString();
        String file_name = "Calorie_Storage.txt";
        try {
            FileOutputStream fileOutputStream = openFileOutput(file_name, MODE_PRIVATE);
            fileOutputStream.write(Message1.getBytes());
            fileOutputStream.close();
            Toast.makeText(getApplicationContext(), "Data Stored", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("MMM MM dd, yyyy");
        long date = System.currentTimeMillis();
        String dateString = sdf.format(date);
        Test.setText(dateString);

    }

    }


