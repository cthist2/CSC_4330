package com.example.rocafellabob.fittigerlife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * setProfileActivity.java\
 * interface people will record their goal data in
 * changed:
 * Date:        Person:     Reason:
 * 11/1/16    Spencer     put data inputting and calculations in. Calculating BMI is now working.
 */
public class setProfileActivity extends AppCompatActivity {
    EditText Weight, Height;
    TextView BMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_profile);

        BMI = (TextView)findViewById(R.id.BMI);
        Weight = (EditText) findViewById(R.id.editWeight);
        Height = (EditText) findViewById(R.id.editHeight);}

    public void writeMessage(View view) {
        double WeightFinal = Double.parseDouble(Weight.getText().toString());
        double HeightFinal = Double.parseDouble(Height.getText().toString());
        String WeightFinalString = Weight.getText().toString();
        String HeightFinalString = Height.getText().toString();
        HeightFinal = HeightFinal /12;
        String Comma = ",";
        String Period = ".";
        String file_name = "Profile.csv";
        double BMIfinal = (WeightFinal * 4.88)/(HeightFinal*HeightFinal);
        String BMIFinalString= Double.toString(BMIfinal);
        try {
            FileOutputStream fileOutputStream = openFileOutput(file_name, MODE_PRIVATE);
            fileOutputStream.write(WeightFinalString.getBytes());
            fileOutputStream.write(Comma.getBytes());
            fileOutputStream.write(HeightFinalString.getBytes());
            fileOutputStream.write(Period.getBytes());
            fileOutputStream.close();
            Toast.makeText(getApplicationContext(), "Data Stored", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BMI.setText(BMIFinalString);
    }
    /*public void readMessage(View view)
    {
        try{
            String Message;
            FileInputStream fileInputStream = openFileInput("Profile.csv");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            while((Message = bufferedReader.readLine())!=null)
            {
                stringBuffer.append(Message +"\n");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();


    } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */
}


