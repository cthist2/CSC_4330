package com.example.rocafellabob.fittigerlife.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.rocafellabob.fittigerlife.UI.interfaces.*;
import com.example.rocafellabob.fittigerlife.data.Data;
import static com.example.rocafellabob.fittigerlife.util.DataConsts.*;

import java.io.File;
import java.util.List;

/**
 * ShowWeightLifting.java 
 * activity that lets you see the past few weight lifting entries
 * Date:        Person:     Reason:
 * 11/11/16     Spencer     Built the recoding information and data storage 
 * 11/16/16     Spencer     More bug fixes to value showing NULL
 * 11/16/16     Thomas      move data processing to separate file (huge refactoring)
 * 11/21/16     Spencer     Attempting to make this function multi usable
 */
public class ShowWeightLifting extends AppCompatActivity implements DisplayActivity, UIInterface {

    TextView DataStore1, DataStore2, DataStore3, DataStore4, DataStore5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_weight_lifting);
        loadElements();
        load();
    }

    @Override
    public void load(View view) {
        load();
    }

    @Override
    public void load() {
        List<String[]> fc = Data.readData(this, weights_csv);
        TextView[] tviews = new TextView[]{DataStore1, DataStore2, DataStore3, DataStore4, DataStore5};
        int i = 0;
        // date weight set rep
        if (fc != null) {
            for (String[] s : fc) {
                if (i > 5) {
                    break;
                }
              tviews[i].setText("Date            " + "Weight    " + "Sets    "+ "Reps    " + newline  +s[0] + "      " + s[1] + "   " + s[2] + "   " + s[3] + "\n");
             //   tviews[i].setText("22");
                i++;
            }
        }
    }

    @Override
    public void loadElements() {
        DataStore1 = (TextView) findViewById(R.id.textViewInsertData1);
        DataStore2 = (TextView) findViewById(R.id.textViewInsertData2);
        DataStore3 = (TextView) findViewById(R.id.textViewInsertData3);
        DataStore4 = (TextView) findViewById(R.id.textViewInsertData4);
        DataStore5 = (TextView) findViewById(R.id.textViewInsertData5);
    }
}
