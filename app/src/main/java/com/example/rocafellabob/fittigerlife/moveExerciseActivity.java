package com.example.rocafellabob.fittigerlife;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * moveExerciseActivity.java\
 * interface people will record their workout data in
 * changed:
 * Date:        Person:     Reason:
 *  10/25/16    Spencer     Update the spinner class to show options
 */
public class moveExerciseActivity extends AppCompatActivity {
    private Spinner spinner1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_exercise);
    }


}



