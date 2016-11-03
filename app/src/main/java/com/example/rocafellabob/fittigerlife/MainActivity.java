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

    /**
     * When activities calls, onCreate, creates the activity
     *
     * @return Nothing
     * @param Bundle SavedInnstance, It is being passsed a Bundle Object
     *
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * When activities called, aka when the button is pressed, it goes to the moveGoals Activity
     *
     * @return Nothing
     * @param View view: basic building blocks of the interface is passed, needed for all new views/activities
     *
     */
    public void moveGoals(View view) {
        Intent intent = new Intent(this,MoveGoalsActivity.class);
        startActivity(intent);
    }
    /**
     * When activities called, aka when the button is pressed, it goes to the moveCalorie Activity
     *
     * @return Nothing
     * @param View view: basic building blocks of the interface is passed, needed for all new views/activities
     *
     */
    public void moveCalorie(View view) {
        Intent intent = new Intent(this,moveCalorieActivity.class);
        startActivity(intent);
    }
    /**
     * When activities called, aka when the button is pressed, it goes to the moveExcercise Activity
     *
     * @return Nothing
     * @param View view: basic building blocks of the interface is passed, needed for all new views/activities
     *
     */
    public void moveExercise(View view) {
        Intent intent = new Intent(this,moveExerciseActivity.class);
        startActivity(intent);
    }
    /**
     * When activities called, aka when the button is pressed, it goes to the moveAdvice Activity
     *
     * @return Nothing
     * @param View view: basic building blocks of the interface is passed, needed for all new views/activities
     *
     */
    public void moveAdvice(View view) {
        Intent intent = new Intent(this,moveAdviceActivity.class);
        startActivity(intent);
    }
    /**
     * When activities called, aka when the button is pressed, it goes to the setProfile Activity
     *
     * @return Nothing
     * @param View view: basic building blocks of the interface is passed, needed for all new views/activities
     *
     */
    public void setProfile(View view) {
        Intent intent = new Intent(this,setProfileActivity.class);
        startActivity(intent);
    }
    public void Cardio(View view) {
        Intent intent = new Intent(this,CardioActivity.class);
        startActivity(intent);
    }



}
