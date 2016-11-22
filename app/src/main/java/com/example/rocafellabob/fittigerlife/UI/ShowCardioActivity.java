package com.example.rocafellabob.fittigerlife.UI;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rocafellabob.fittigerlife.UI.interfaces.*;
import com.example.rocafellabob.fittigerlife.data.Data;
import static com.example.rocafellabob.fittigerlife.util.DataConsts.*;
import java.text.ParseException;
import java.util.Date;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ShowCardioActivity.java
 * activity that lets you see the past few weight lifting entries
 * Date:        Person:     Reason:
 * 11/21/16     Spencer     Used show weights as template and built this
 * 11/22/16     Thomas      Fix spacing, fix entries
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
        // date Activity Input
        if (fc != null) {
            int numentries = fc.size();
            // need to start from the end to get the most recent ones
            for (int i = numentries - 1; i > numentries - 6; i--) {
                if(i < 0) {
                    break; // incase less than 5 entries
                }
                String[] s = fc.get(i);
                // calculate index of textview to update
                // for example: 10 entries so i goes from 9 to 5
                // when i is 9, index is 0
                // when i is 8, index is 1
                // so on and numentries is 10
                int textview_index = numentries - 1 - i;
                tviews[textview_index].setTextSize(20);
                tviews[textview_index].setTypeface(Typeface.MONOSPACE);
                String sYear = "", sMonth = "", sDay = "";
                try {
                    // extract year, day, month for printing
                    Date date = sdf.parse(s[0]);
                    sYear = year.format(date);
                    sMonth = month.format(date);
                    sDay = day.format(date);
                } catch (ParseException ex) {
                    Toast.makeText(getApplicationContext(), "Data load failed", Toast.LENGTH_LONG).show();
                }
                tviews[textview_index].setText(
                        String.format("%-12s", "Date") + 
                        String.format("%-10s", "Activity") + 
                        String.format("%-10s", "Time") + 
                        newline + 
                        String.format("%-12s", sMonth + "/" + sDay + "/" + sYear) +
                        String.format("%-10s", s[1]) + 
                        String.format("%-10s", s[2])
                );
                //   tviews[i].setText("22");
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

