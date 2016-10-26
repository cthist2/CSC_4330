package com.example.rocafellabob.fittigerlife;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.TextView;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.FileInputStream;
import java.io.FileOutputStream;
/**
 * moveExerciseActivity.java\
 * interface people will record their goal data in
 * changed:
 * Date:        Person:     Reason:
 *  10/26/16    Spencer     Worked on data inputting and storing
 */
public class MoveGoalsActivity extends AppCompatActivity {
    Button b1;
    EditText Edi1;
    String data;
    private String file = "userData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_goals);
        b1=(Button)findViewById(R.id.button2);
        Edi1=(EditText)findViewById(R.id.Edi1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=Edi1.getText().toString();

                try {
                    FileOutputStream fOut = openFileOutput(file,MODE_WORLD_READABLE);
                    fOut.write(data.getBytes());
                    fOut.close();
                    Toast.makeText(getBaseContext(),"file saved",Toast.LENGTH_SHORT).show();
                }

                catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

        }});}}









