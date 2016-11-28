package com.example.rocafellabob.fittigerlife.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import static com.example.rocafellabob.fittigerlife.util.DataConsts.profile_csv;
import java.io.File;

/**
 * MainActivity.java
 * main screen
 * Date:        Person:     Reason:
 * 11/1/16      Spencer     put data inputting and calculations in. Calculating BMI is now working
 * 11/3/16      Spencer     Added the age parameter and the gender buttons
 * 11/16/16     Thomas      recreate (huge refactoring)
 * 11/25/16     Thomas      first time launch check
 */
public class MainActivity extends AppCompatActivity {
    /**
     * @param Bundle savedInstanceState (The save instancestate from the xml file
     * @description: once the activity is called, the activity is created and all functions in oncreate called
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkFirstLaunch();
    }

    /**
     * check if the its the app's first time or
     * the memory is cleared.
     */
    private void checkFirstLaunch() {
        File file = new File(profile_csv);
        if(file.exists()) {
            Toast.makeText(getApplicationContext(), "Looks like this is your first time here. Create your profile.", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, EditProfileActivity.class);
            startActivity(intent);
        }
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
