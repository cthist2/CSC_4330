package com.example.rocafellabob.fittigerlife;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

}
