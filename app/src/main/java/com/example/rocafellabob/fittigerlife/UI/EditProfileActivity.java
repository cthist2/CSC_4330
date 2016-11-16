package com.example.rocafellabob.fittigerlife.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.rocafellabob.fittigerlife.UI.interfaces.EditActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.example.rocafellabob.fittigerlife.data.Data;

/**
 * ProfileActivity.java\ interface people will record their goal data in
 changed: Date: Person: Reason: 11/1/16 Spencer put data inputting and
 calculations in. Calculating BMI is now working. 11/3/16 Spencer Added the
 * age parameter and the gender buttons
 */
public class EditProfileActivity extends AppCompatActivity implements EditActivity{

    EditText Weight, Height, Age;
    TextView BMI;
    String Gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        BMI = (TextView) findViewById(R.id.BMI);
        Weight = (EditText) findViewById(R.id.editWeight);
        Height = (EditText) findViewById(R.id.editHeight);
        Age = (EditText) findViewById(R.id.editAge);
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

}
