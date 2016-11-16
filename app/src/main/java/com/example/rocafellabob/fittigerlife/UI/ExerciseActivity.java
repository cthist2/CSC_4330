package com.example.rocafellabob.fittigerlife.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import android.widget.EditText;
import com.example.rocafellabob.fittigerlife.moveAdviceActivity;

public class ExerciseActivity extends AppCompatActivity {

    @Override

    /**
     * When activities calls, onCreate, creates the activity
     *
     * @return Nothing
     * @param Bundle SavedInnstance, It is being passsed a Bundle Object
     *
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
    }

    public void openWeights(View view) {
        Intent intent = new Intent(this, WeightsActivity.class);
        startActivity(intent);
    }
    
    public void openCardio(View view) {
        Intent intent = new Intent(this, CardioActivity.class);
        startActivity(intent);
    }

}
