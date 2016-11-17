package com.example.rocafellabob.fittigerlife.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * MainActivity.java
 * main screen
 * Date:        Person:     Reason:
 * 11/1/16      Spencer     put data inputting and calculations in. Calculating BMI is now working
 * 11/3/16      Spencer     Added the age parameter and the gender buttons
 * 11/16/16     Thomas      recreate (huge refactoring)
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * opens the profile activity
     * 
     * @param view the owner of the function call
     */
    public void openProfile(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    /**
     * opens the goals activity
     * 
     * @param view the owner of the function call
     */
    public void openGoals(View view) {
        Intent intent = new Intent(this, GoalsActivity.class);
        startActivity(intent);
    }

    /**
     * opens the exercise activity
     * 
     * @param view the owner of the function call
     */
    public void openRecord(View view) {
        Intent intent = new Intent(this, ExerciseActivity.class);
        startActivity(intent);
    }

    /**
     * opens the calories activity
     * 
     * @param view the owner of the function call
     */
    public void openCalories(View view) {
        Intent intent = new Intent(this, CaloriesActivity.class);
        startActivity(intent);
    }
}
