/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.rocafellabob.fittigerlife.UI;

import android.app.Activity;
import android.os.Bundle;
import com.example.rocafellabob.fittigerlife.graphs.GraphView;

/**
 *
 * @author thorn
 */
public class GraphActivity extends Activity {
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // second value is "x" because horizontal screen
        float[] mypoints = {
            // first line
            210, 0,
            100, 1,
            
            // second line
            100, 1,
            200, 2,
            
            // third line
            200, 2,
            000, 3,
            
            // fourth line
            000, 3,
            300, 4,
            
            // fifth line
            300, 4,
            100, 5,
            
            // sixth line
            100, 5,
            200, 6
        };
        setContentView(new GraphView(this, mypoints));
    }
}
