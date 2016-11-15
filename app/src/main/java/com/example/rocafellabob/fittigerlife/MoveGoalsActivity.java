package com.example.rocafellabob.fittigerlife;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.FileNotFoundException;
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

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * moveExerciseActivity.java\
 * interface people will record their goal data in
 * changed:
 * Date:        Person:     Reason:
 * 10/26/16    Spencer     Worked on data inputting and storing
 * 10/29/16    Spencer     Worked on adding permission to access to internal storage\
 * 10/30/16    Spencer     Fixed the saving internal storage, I believe?
 */
public class MoveGoalsActivity extends AppCompatActivity {
    Button button2;
    EditText Edi1;
    @Override
    /**
     * Creates the Activity/view
     *
     * @return sorted module
     * @param See onCreate in MainActivity.java
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_goals);
        button2 = (Button) findViewById(R.id.button2);
        Edi1 = (EditText) findViewById(R.id.Edi1);}
    /**
     * Writes the message to the text file when its called by the onClick in the XML file.
     *
     *
     * @param View view: it recieves the view from the XML file, more exact, content_move_calorie.xml
     * @throws errors is data writing messes up
     */
    public void writeMessage(View view) {
        String Message1 = Edi1.getText().toString();
        String file_name = "data_Storage.txt";
        try {
            FileOutputStream fileOutputStream = openFileOutput(file_name, MODE_PRIVATE);
            fileOutputStream.write(Message1.getBytes());
            fileOutputStream.close();
            Toast.makeText(getApplicationContext(), "Data Stored", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


















