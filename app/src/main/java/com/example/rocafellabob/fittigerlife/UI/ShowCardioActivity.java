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
 * ShowCardioActivity.java
 * activity that lets you see the past few weight lifting entries
 * Date:        Person:     Reason:
 * 11/21/16     Spencer     Used show weights as template and built this
 */
public class ShowCardioActivity extends AppCompatActivity implements DisplayActivity, UIInterface {

    TextView DataStore1, DataStore2, DataStore3, DataStore4, DataStore5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cardio);
        loadElements();
        load();
    }

    @Override
    public void load(View view) {
        load();
    }

    @Override
    public void load() {
        List<String[]> fc = Data.readData(this, cardio_csv);
        TextView[] tviews = new TextView[]{DataStore1, DataStore2, DataStore3, DataStore4, DataStore5};
        int i = 0;
        // date Activity Input
        if (fc != null) {
            for (String[] s : fc) {
                if (i > 5) {
                    break;
                }
                tviews[i].setText("Date            " + "Activity    " + "Time    "    + newline  +s[0] + "      " + s[1] + "   " + s[2] +   "\n");
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

