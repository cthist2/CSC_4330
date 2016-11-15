/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.rocafellabob.fittigerlife.data;

import static android.content.Context.MODE_PRIVATE;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thorn
 */
public class Data {
    final static String comma = ",";
    final static String period = ".";
    final static String profile_csv = "Profile.csv";
    final static String calorie_csv = "Calorie_Storage.txt";
    final static String cardio_csv = "Cardio.csv";
    
    public static void recordCalorieData(String calories, String data) {
        
    }
    
    public static void recordGoalsData() {
        
    }
    
    public static void recordCardioData(AppCompatActivity a, String activity, String time, String date) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = a.openFileOutput(cardio_csv, MODE_PRIVATE);
            // type,time,date.
            fileOutputStream.write(activity.getBytes());
            fileOutputStream.write(comma.getBytes());
            fileOutputStream.write(time.getBytes());
            fileOutputStream.write(comma.getBytes());
            fileOutputStream.write(date.getBytes());
            fileOutputStream.write(period.getBytes());
            // success
            Toast.makeText(a.getApplicationContext(), "Data Stored", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            // failure
            e.printStackTrace();
            Toast.makeText(a.getApplicationContext(), "Failed Data Storage", Toast.LENGTH_LONG).show();
        }
        finally {
            try {
                fileOutputStream.close();
            } catch (Exception e) {
            }
        }
    }
    
    public static double recordProfileData(AppCompatActivity a, String weight, String age, String height, String gender) {
        FileOutputStream fileOutputStream = null;
        // (weight * 4.88) / (height in feet squared)
        double BMIfinal = (Double.parseDouble(weight) * 4.88) / ((Double.parseDouble(height) / 12) * (Double.parseDouble(height) / 12));
        try {
            fileOutputStream = a.openFileOutput(profile_csv, MODE_PRIVATE);
            // weight,height,age,gender.
            fileOutputStream.write(weight.getBytes());
            fileOutputStream.write(comma.getBytes());
            fileOutputStream.write(height.getBytes());
            fileOutputStream.write(comma.getBytes());
            fileOutputStream.write(age.getBytes());
            fileOutputStream.write(gender.getBytes());
            fileOutputStream.write(period.getBytes());
            // success
            Toast.makeText(a.getApplicationContext(), "Data Stored", Toast.LENGTH_LONG).show();
        }
        catch(Exception e) {
            // failure
            e.printStackTrace();
            Toast.makeText(a.getApplicationContext(), "Failed Data Storage", Toast.LENGTH_LONG).show();
        }
        finally {
            // make sure to close f o s
            try {
                fileOutputStream.close();
            } 
            catch (Exception e) {
            }
        }
        return BMIfinal;
    }
    
}
