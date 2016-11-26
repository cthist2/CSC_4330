package com.example.rocafellabob.fittigerlife.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Exercise.java
 * pick what kind of exercise you want to record
 * Date:        Person:     Reason:
 * 11/16/16     Thomas      create activity (huge refactoring)
 */
public class ExerciseActivity extends AppCompatActivity {

    @Override
    /**
     * @param Bundle savedInstanceState (The save instancestate from the xml file
     * @description: once the activity is called, the activity is created and all functions in oncreate called
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
    }

    /**
     * Opens the weights activity
     * 
     * @param view the owner of the function call
     */
    public void openWeights(View view) {
        Intent intent = new Intent(this, WeightsActivity.class);
        startActivity(intent);
    }

    /**
     * opens the cardio activity
     * 
     * @param view the owner of the function call
     */
    public void openCardio(View view) {
        Intent intent = new Intent(this, CardioActivity.class);
        startActivity(intent);
    }

}
