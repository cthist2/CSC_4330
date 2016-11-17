package com.example.rocafellabob.fittigerlife.UI.interfaces;

import android.view.View;

/**
 * DisplayActivity.java
 * interface that any activity that displays data will implement
 * 11/16/16     Thomas      create file (huge refactoring)
 */
public interface DisplayActivity {

    /**
     * any activity that displays things will have to load from a file reads the
     * file's contents and updates the screen accordingly
     *
     * @param view the owner of the function call
     */
    public void load(View view);

    /**
     * the helper load function
     */
    public void load();
}
