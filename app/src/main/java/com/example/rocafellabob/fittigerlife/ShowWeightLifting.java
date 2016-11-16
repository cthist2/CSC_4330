package com.example.rocafellabob.fittigerlife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
public class ShowWeightLifting extends AppCompatActivity {

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

        List<String[]> fc = Data.readData(this, "weightLiftingStorage.csv");
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
//        }
//        StringBuilder sb = new StringBuilder();
//        String fileIn = "weightLiftingStorage.csv";
//        try {
//            FileInputStream fin = openFileInput(fileIn);
//            BufferedReader reader = new BufferedReader(new InputStreamReader(fin, "UTF-8"));
//            String line = null;
//            String C;
//            int i=0;
//            String[] DataRead =new String[5];
//            DataRead[0] ="NULL";
//            DataRead[1] ="NULL";
//            DataRead[2] ="NULL";
//            DataRead[3] ="NULL";
//            DataRead[4] ="NULL";
//
//            String cvsSplitBy = ",";
//
//            while ((C = reader.readLine()) != null) {
//                 DataRead = C.split(cvsSplitBy);
//                fullString1 =  DataRead[0];
//            //    fullString2 += "\n" +DataRead[1];
//             //   fullString3 += "\n" +DataRead[2];
//             //   fullString4 += "\n" +DataRead[3];
//            //    fullString5 += "\n" +DataRead[4];
//               DataStore1.setText( fullString1);
//          //      DataStore2.setText( fullString2);
//           //     DataStore3.setText( fullString3);
//           //     DataStore4.setText( fullString4);
//          //      DataStore5.setText( fullString5);
//                fullString1 = DataStore1.getText().toString();
//           //     fullString2 = DataStore2.getText().toString();
//            //    fullString3 = DataStore3.getText().toString();
//          //      fullString4 = DataStore4.getText().toString();
//           //     fullString5 = DataStore5.getText().toString();
//                fullString1 += "\n";
//
//           }
//
//            fin.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}
