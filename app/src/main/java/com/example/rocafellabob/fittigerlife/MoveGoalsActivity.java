package com.example.rocafellabob.fittigerlife;

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.BufferedReader;
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
import com.example.rocafellabob.fittigerlife.data.Data;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * moveExerciseActivity.java\ interface people will record their goal data in
 * changed: Date: Person: Reason: 10/26/16 Spencer Worked on data inputting and
 * storing 10/29/16 Spencer Worked on adding permission to access to internal
 * storage\ 10/30/16 Spencer Fixed the saving internal storage, I believe?
 */
public class MoveGoalsActivity extends AppCompatActivity {

    Button button2;
    EditText Edi1;
    TextView Wrist, Waist, Weight, Neck;

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

        Edi1 = (EditText) findViewById(R.id.Edi1);
        Wrist = (TextView) findViewById(R.id.textWrist);
        Waist = (TextView) findViewById(R.id.textWaiste);
        Weight = (TextView) findViewById(R.id.textWeight);
        Neck = (TextView) findViewById(R.id.textNeck);
        updateMeasurementsScreen();
        
//        StringBuilder sb = new StringBuilder();
//        String fileIn = "Measurement.csv";
//        try {
//            FileInputStream fin = openFileInput(fileIn);
//            BufferedReader reader = new BufferedReader(new InputStreamReader(fin, "UTF-8"));
//            String line = null;
//            String C;
//            String cvsSplitBy = ",";
//            while ((C = reader.readLine()) != null) {
//                String[] DataRead = C.split(cvsSplitBy);
//                Wrist.setText(DataRead[0]);
//                Waiste.setText(DataRead[1]);
//                Weight.setText(DataRead[2]);
//                Neck.setText(DataRead[3]);
//            }
//            fin.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public void updateMeasurementsScreen() {
        List<String[]> data = Data.readData(this, "Measurement.csv");
        String[] measurements = data.get(0); // should only have 1 line
        if (measurements.length == 4) { // fml workaround
            Wrist.setText(measurements[0]);
            Waist.setText(measurements[1]);
            Weight.setText(measurements[2]);
            Neck.setText(measurements[3]);
        }
    }
    public void writeMessage(View view) {
        updateMeasurementsScreen();
    }

    public void EditGoal(View view) {
        Intent intent = new Intent(this, editGoal.class);
        startActivity(intent);
    }
}
