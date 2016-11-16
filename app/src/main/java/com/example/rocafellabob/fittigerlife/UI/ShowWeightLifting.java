package com.example.rocafellabob.fittigerlife.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.rocafellabob.fittigerlife.UI.interfaces.DisplayActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import com.example.rocafellabob.fittigerlife.data.Data;
import java.util.List;

/**
 * ShowWeightLifting.java interface people will record their goal data in
 * changed: Date: Person: Reason: 11/11/16 Spencer Built the recoding
 * information and data storage 11/16/16 Spencer More bug fixes to value showing
 * NULL
 */
public class ShowWeightLifting extends AppCompatActivity implements DisplayActivity{

    final static String file_name =  "weightLiftingStorage.csv";
    TextView DataStore1, DataStore2, DataStore3, DataStore4, DataStore5, DataStore6, DataStore7, DataStore8, DataStore9, DataStore10, DataStore11, DataStore12, DataStore13;

    @Override
    /**
     * When activities called, create new activity
     *
     * @return Nothing
     * @param Bundle savedInstanceState, collects info from the last activity
     *
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int count = 0;
        String fullString;
        setContentView(R.layout.activity_show_weight_lifting);
        DataStore1 = (TextView) findViewById(R.id.textViewInsertData1);
        DataStore2 = (TextView) findViewById(R.id.textViewInsertData2);
        DataStore3 = (TextView) findViewById(R.id.textViewInsertData3);
        DataStore4 = (TextView) findViewById(R.id.textViewInsertData4);
        DataStore5 = (TextView) findViewById(R.id.textViewInsertData5);

        List<String[]> fc = Data.readData(this, file_name);
        TextView[] tviews = new TextView[]{DataStore1, DataStore2, DataStore3, DataStore4, DataStore5};
        int i = 0;
        // date weight set rep
        for (String[] s : fc) {
            if (i > 5) {
                break;
            }
            tviews[i].setText(s[0] + " " + s[1] + " " + s[2] + " " + s[3] + "\n");
            i++;
        }
    }

    @Override
    public void load(View view) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
