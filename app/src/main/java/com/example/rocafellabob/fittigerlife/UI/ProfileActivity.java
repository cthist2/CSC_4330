package com.example.rocafellabob.fittigerlife.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.rocafellabob.fittigerlife.UI.interfaces.DisplayActivity;
import com.example.rocafellabob.fittigerlife.UI.interfaces.EditActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.example.rocafellabob.fittigerlife.data.Data;
import com.example.rocafellabob.fittigerlife.graphs.GraphView;
import java.util.List;

/**
 * ProfileActivity.java\ interface people will record their goal data in
 changed: Date: Person: Reason: 11/1/16 Spencer put data inputting and
 calculations in. Calculating BMI is now working. 11/3/16 Spencer Added the
 * age parameter and the gender buttons
 */
public class ProfileActivity extends AppCompatActivity implements DisplayActivity{

    TextView Weight, Height, Age, BMI;
    String Gender;
    final static String file_name = "Profile.csv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        BMI = (TextView) findViewById(R.id.BMIDisplay);
        Weight = (TextView) findViewById(R.id.WeightDisplay);
        Height = (TextView) findViewById(R.id.HeightDisplay);
        Age = (TextView) findViewById(R.id.AgeDisplay);
        load();
    }

    // reload the data when the screen comes back up
    @Override
    protected void onStart() {
        super.onStart();
        BMI = (TextView) findViewById(R.id.BMIDisplay);
        Weight = (TextView) findViewById(R.id.WeightDisplay);
        Height = (TextView) findViewById(R.id.HeightDisplay);
        Age = (TextView) findViewById(R.id.AgeDisplay);
        load();
    }
    
    public void update(View view) {
        String WeightFinalString = Weight.getText().toString();
        String HeightFinalString = Height.getText().toString();
        String AgeFinalString = Age.getText().toString();
        double BMIval = Data.recordProfileData(this, WeightFinalString, AgeFinalString, HeightFinalString, Gender);
        BMI.setText(Double.toString(BMIval));
    }
    
    public void Male(View view) {
        Gender = "Male";
    }

    public void Female(View view) {
        Gender = "Female";
    }

    public void load() {
        // weight age height gender
        List<String[]> fc = Data.readData(this, file_name);
        if(fc != null) {
            TextView[] tviews = new TextView[]{Weight, Age, Height};
            String[] info = fc.get(0);
            // weight age height gender
            for (int i = 0; i < 3; i++) {
                tviews[i].setText(info[i]);
            }
        }
    }
    
    @Override
    public void load(View view) {
        load();
    }
    
    public void editProfile(View view) {
        Intent intent = new Intent(this, EditProfileActivity.class);
        startActivity(intent);
    }
    
    public void createGraph(View view) {
//        Intent intent = new Intent(this, GraphActivity.class);
//        startActivity(intent);
        float[] mypoints = {
            // first line
            210, 20161111,
            100, 20161112,
            
            // second line
            100, 20161112,
            200, 20161113,
            
            // third line
            200, 20161113,
            000, 20161114,
            
            // fourth line
            000, 20161114,
            300, 20161115,
            
            // fifth line
            300, 20161115,
            100, 20161116,
            
            // sixth line
            100, 20161116,
            200, 20161117
        };
//float[] mypoints = {
//            // first line
//            210, 0,
//            100, 1,
//            
//            // second line
//            100, 1,
//            200, 2,
//            
//            // third line
//            200, 2,
//            000, 3,
//            
//            // fourth line
//            000, 3,
//            300, 4,
//            
//            // fifth line
//            300, 4,
//            100, 5,
//            
//            // sixth line
//            100, 5,
//            200, 6
//        };
        setContentView(new GraphView(this, mypoints));
    }

}
