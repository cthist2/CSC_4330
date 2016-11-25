package com.example.rocafellabob.fittigerlife.UI.interfaces;

import android.view.View;

/**
 * EditActivity.java
 * interface that any activity that edits data will implement
 * 11/16/16     Thomas      create file (huge refactoring)
 * 11/22/16     Thomas      added function to check format of input
 */
public interface EditActivity {

    /**
     * any activity that updates things has to update (not append) to a file
     * updates the file
     *
     * @param view the owner of the function call
     */
    public void update(View view);
    
    /**
     * function that will verify the input is the correct format i.e. numbers only
     * 
     * @param st the string to check
     */
    public boolean checkFormat(String st);
}
