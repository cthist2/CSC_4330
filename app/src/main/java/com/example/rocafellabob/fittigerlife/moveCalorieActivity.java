package com.example.rocafellabob.fittigerlife;

import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.rocafellabob.fittigerlife.data.Data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * moveCalorieActivity.java\ For recording calories and adding them up changed:
 * Date: Person: Reason: 11/1/16 Spencer Added UI to Xml, put data inputting to
 * file and worked on date function. 11/13/16 Spencer Worked on the storing of
 * the calories 11/14/16 Spencer fixed calories counter
 */
public class moveCalorieActivity extends AppCompatActivity {

    EditText caloriesEntered;
    TextView caloriesReturned;
    TextView Test;
    int calorieTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_calorie);
        caloriesEntered = (EditText) findViewById(R.id.caloriesEntered);
        caloriesReturned = (TextView) findViewById(R.id.CaloriesOutput);

    }

    /**
     * Creates the recordCalories Method
     *
     * @return sorted module
     * @param View view View data and displays it.
     */
    public void recordCalories(View view) {
        Test = (TextView) findViewById(R.id.Test);

        String caloriesFinalString = caloriesEntered.getText().toString();
        int calories = Integer.parseInt(caloriesFinalString);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String date = sdf.format(new Date());

        Data.recordData(this, "Calorie_Storage.csv", new String[]{date, caloriesFinalString});
        List<String[]> data = Data.readData(this, "Calorie_Storage.csv");
        calorieTotal = 0;
        for (String[] s : data) { // for every entry in data, find entries that match the date and add em up
            if (s[0].equals(date)) {
                calorieTotal += Integer.parseInt(s[1]);
            }
        }
        caloriesReturned.setText(Integer.toString(calorieTotal));
        // String dates = String.valueOf(date);
//        String Comma = ",";
//        String Period = ".";
//        String file_name = "Calorie_Storage.csv";
//        //record data
//        try {
//            //write line method
//            FileOutputStream fileOutputStream = openFileOutput(file_name, MODE_PRIVATE);
//            fileOutputStream.write(date.getBytes());
//            fileOutputStream.write(Comma.getBytes());
//            fileOutputStream.write(caloriesFinalString.getBytes());
//            fileOutputStream.write(Period.getBytes());
//            fileOutputStream.close();
//            Toast.makeText(getApplicationContext(), "Data Stored", Toast.LENGTH_LONG).show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            StringBuilder sb = new StringBuilder();
//            FileInputStream fin = openFileInput(file_name);
//            BufferedReader reader = new BufferedReader(new InputStreamReader(fin, "UTF-8"));
//            String line = null;
//            String C;
//            String cvsSplitBy = ",";
//            String date2 = "NULL";
//            String calories1 = "NULL";
//
//            while ((C = reader.readLine()) != null) {
//
//                String[] DataRead = C.split(cvsSplitBy);
//                date2 = DataRead[0];
//                //checks if its the same day
//                if (date2.equals(date)) {
//                    calorieTotal = calorieTotal + calories;
//                } else {
//
//                    calorieTotal = calories;
//                }
//
//            }
//
//            fin.close();
//            reader.close();
//            String CaloriePrinter = Integer.toString(calorieTotal);
//            //       String dateString = sdf.format(date);
//            caloriesReturned.setText(CaloriePrinter);
//
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
