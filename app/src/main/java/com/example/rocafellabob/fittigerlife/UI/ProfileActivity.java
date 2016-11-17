package com.example.rocafellabob.fittigerlife.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.rocafellabob.fittigerlife.UI.interfaces.*;
import com.example.rocafellabob.fittigerlife.data.Data;
import com.example.rocafellabob.fittigerlife.graphs.GraphView;
import static com.example.rocafellabob.fittigerlife.util.DataConsts.*;

import java.util.List;

/**
 * ProfileActivity.java\ interface people will record their goal data in
 changed: Date: Person: Reason: 11/1/16 Spencer put data inputting and
 calculations in. Calculating BMI is now working. 11/3/16 Spencer Added the
 * age parameter and the gender buttons
 */
public class ProfileActivity extends AppCompatActivity implements DisplayActivity, UIInterface{

    TextView Weight, Height, Age, BMI;
    String Gender;
    Spinner GraphTypes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        loadElements();
        load();
    }

    @Override
    public void loadElements() {
        GraphTypes = (Spinner) findViewById(R.id.spinner2);
        BMI = (TextView) findViewById(R.id.BMIDisplay);
        Weight = (TextView) findViewById(R.id.WeightDisplay);
        Height = (TextView) findViewById(R.id.HeightDisplay);
        Age = (TextView) findViewById(R.id.AgeDisplay);
    }
    
    // reload the data when the screen comes back up
    @Override
    protected void onStart() {
        super.onStart();
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
        List<String[]> fc = Data.readData(this, profile_csv);
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
        String graphtype = GraphTypes.getSelectedItem().toString();
        double[] mypoints = Data.getData(this, graphtype);
        setContentView(new GraphView(this, mypoints));
    }
}
