/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.rocafellabob.fittigerlife.UI.interfaces;

import android.view.View;

/**
 *
 * @author thorn
 */
public interface DisplayActivity {
    /**
     * any activity that displays things will have to load from a file
     * reads the file's contents and updates the screen accordingly
     * @param view 
     */
    public void load(View view);
    /**
     * the helper load function
     */
    public void load();
}
