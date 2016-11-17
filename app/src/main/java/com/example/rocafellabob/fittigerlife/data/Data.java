/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.rocafellabob.fittigerlife.data;

import static android.content.Context.MODE_APPEND;
import static android.content.Context.MODE_PRIVATE;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import static com.example.rocafellabob.fittigerlife.util.DataConsts.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author thorn
 */
public class Data {
    
    /**
     * record data to a file
     * @param act the activity being called from
     * @param filename the name of the file to write to
     * @param data the data to be written
     */
    public static boolean recordData(AppCompatActivity act, String filename, String[] data) {
        FileOutputStream fileoutput = null;
        try {
            fileoutput = act.openFileOutput(filename, MODE_APPEND); // attempt to open file and make sure to append not overwrite
            if(data.length > 0) { // if there is some kind of data thats being written also to avoid indexoutofbounds errors
                fileoutput.write(data[0].getBytes()); //write the first thing
                for(int i = 1; i < data.length; i++) {  // write everything else with commas before them
                    fileoutput.write(comma.getBytes()); 
                    fileoutput.write(data[i].getBytes());
                }
                fileoutput.write(newline.getBytes()); // write a newline at the end
                Toast.makeText(act.getApplicationContext(), "Stored the data", Toast.LENGTH_LONG).show();
                return true;
            }
        }
        catch(Exception e) {
        }
        finally {
            try {
                fileoutput.close();
            } 
            catch (Exception e) {
            }
        }
        Toast.makeText(act.getApplicationContext(), "Failed Data Storage", Toast.LENGTH_LONG).show();
        return false;
    }
    
    /**
     * read data from a file 
     * @param act the activity being called from
     * @param filename the filename to read
     * @return a list of string arrays that represent the entries
     */
    public static List<String[]> readData(AppCompatActivity act, String filename) {
        FileInputStream fileinput = null;
        List<String[]> entries = null;
        String entry;
        try {
            fileinput = act.openFileInput(filename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileinput, "UTF-8"));
            entries = new ArrayList<String[]>();
            while ((entry = reader.readLine()) != null) {
                entries.add(entry.split(comma));
            }
            Toast.makeText(act.getApplicationContext(), "Got the data", Toast.LENGTH_LONG).show();
        }
        catch(Exception e) {
            Log.d("ERROR", e.getMessage());
            Toast.makeText(act.getApplicationContext(), "Failed Data Read", Toast.LENGTH_LONG).show();
        }
        finally {
            try {
                fileinput.close();
            } 
            catch (Exception e) {
            }
        }
        return entries;
    }
         
    public static double recordProfileData(AppCompatActivity act, String weight, String age, String height, String gender) {
        FileOutputStream fileOutputStream = null;
        // (weight * 4.88) / (height in feet squared)
        double BMIfinal = (Double.parseDouble(weight) * 4.88) / ((Double.parseDouble(height) / 12) * (Double.parseDouble(height) / 12));
        try {
            fileOutputStream = act.openFileOutput(profile_csv, MODE_PRIVATE);
            // weight,height,age,gender.
            fileOutputStream.write(weight.getBytes());
            fileOutputStream.write(comma.getBytes());
            fileOutputStream.write(height.getBytes());
            fileOutputStream.write(comma.getBytes());
            fileOutputStream.write(age.getBytes());
            fileOutputStream.write(comma.getBytes());
            fileOutputStream.write(gender.getBytes());
            fileOutputStream.write(newline.getBytes());
            // success
            Toast.makeText(act.getApplicationContext(), "Data Stored", Toast.LENGTH_LONG).show();
        }
        catch(Exception e) {
            // failure
            Log.d("ERROR", e.getMessage());
            Toast.makeText(act.getApplicationContext(), "Failed Data Storage", Toast.LENGTH_LONG).show();
        }
        finally {
            try {
                fileOutputStream.close();
            } 
            catch (Exception e) {
            }
        }
        return BMIfinal;
    }
        
    public static void recordGoal(AppCompatActivity act, String wrist, String neck, String waist, String weight){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = act.openFileOutput(measurements_csv, MODE_PRIVATE);
            // wrist,neck,waist,weight
            fileOutputStream.write(wrist.getBytes());
            fileOutputStream.write(comma.getBytes());
            fileOutputStream.write(neck.getBytes());
            fileOutputStream.write(comma.getBytes());
            fileOutputStream.write(waist.getBytes());
            fileOutputStream.write(comma.getBytes());
            fileOutputStream.write(weight.getBytes());
            fileOutputStream.write(newline.getBytes());
            // success
            Toast.makeText(act.getApplicationContext(), "Data Stored", Toast.LENGTH_LONG).show();
        }
        catch(Exception e) {
            // failure
            Log.d("ERROR", e.getMessage());
            Toast.makeText(act.getApplicationContext(), "Failed Data Storage", Toast.LENGTH_LONG).show();
        }
        finally {
            // make sure to close f o s
            try {
                fileOutputStream.close();
            } 
            catch (Exception e) {
            }
        }
    }
    
    public static double[] getData(AppCompatActivity act, String graphtype) {
        String filename;
        int index = 0;
        // date calories
        if(graphtype.equals("Daily Calories")) {
            filename = calories_csv;
        // date activitytype time
        }else if(graphtype.equals("Running Time") || graphtype.equals("Biking Time") || graphtype.equals("Walking Time")) {
            filename = cardio_csv;
        // date sets reps weights
        }else if(graphtype.equals("Daily Sets") || graphtype.equals("Daily Reps") || graphtype.equals("Daily Weights")) {
            filename = weights_csv;
            if(graphtype.equals("Daily Sets"))
                index = 2; // position of sets in the array
            else if(graphtype.equals("Daily Weights"))
                index = 1; // position of weights in the array
            else
                index = 3; // position of reps in the array
        }else{
            return null;
        }
        List<String[]> data = readData(act, filename);
        List<Double> dp = new ArrayList<>();
        if(data != null && data.size() > 0) {
            int i = 0;
            String date = data.get(i)[0];
            double total = Double.parseDouble(data.get(i)[index]);
            i++;
            while(i < data.size() && date.equals(data.get(i)[0])) {
                total += Double.parseDouble(data.get(i)[index]);
                i++;
            }
            dp.add(total);
            dp.add(Double.parseDouble(date));
            for(; i < data.size(); i++) {
                date = data.get(i)[0];
                total = Double.parseDouble(data.get(i)[index]);
                while(i < data.size() && date.equals(data.get(i)[0])) {
                    total += Double.parseDouble(data.get(i)[index]);
                    i++;
                }
                dp.add(total);
                dp.add(Double.parseDouble(date));
                dp.add(total);
                dp.add(Double.parseDouble(date));
            }
        }
        double[] returnarray = new double[dp.size()];
        for(int i = 0; i < returnarray.length; i++) {
            returnarray[i] = dp.get(i);
            Log.d("msg", String.format("%.0f", returnarray[i]));
        }
        return returnarray;
    }
}
