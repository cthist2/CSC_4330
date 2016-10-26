package com.example.rocafellabob.fittigerlife;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void moveGoals(View view) {
        Intent intent = new Intent(this,MoveGoalsActivity.class);
        startActivity(intent);
    }
    public void moveCalorie(View view) {
        Intent intent = new Intent(this,moveCalorieActivity.class);
        startActivity(intent);
    }

    public void moveExercise(View view) {
        Intent intent = new Intent(this,moveExerciseActivity.class);
        startActivity(intent);
    }
    public void moveAdvice(View view) {
        Intent intent = new Intent(this,moveAdviceActivity.class);
        startActivity(intent);
    }



}
