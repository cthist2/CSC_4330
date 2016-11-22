/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.rocafellabob.fittigerlife.UI.interfaces;

import android.view.View;

/**
 * RecordActivity.java
 * interface that any activity that records data will implement
 * 11/16/16     Thomas      create file (huge refactoring)
 * 11/22/16     Thomas      added function to check format of input
 */
public interface RecordActivity {

    /**
     * any activity that records things appends to the file record the activity
     * to the file
     *
     * @param view the owner of the function call
     */
    public void record(View view);
    
    /**
     * function that will verify the input is the correct format i.e. numbers only
     * 
     * @param st the string to check
     */
    public boolean checkFormat(String st);
}
