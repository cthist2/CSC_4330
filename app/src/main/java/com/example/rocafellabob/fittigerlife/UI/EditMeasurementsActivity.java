
package com.example.rocafellabob.fittigerlife.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.rocafellabob.fittigerlife.UI.interfaces.*;
import com.example.rocafellabob.fittigerlife.data.Data;
public class EditMeasurementsActivity extends AppCompatActivity implements EditActivity, UIInterface {

    EditText weight, wrist, neck, waiste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_measurements);

        loadElements();

    }

    @Override
    public void loadElements() {
        wrist = (EditText) findViewById(R.id.editWrist);
        weight = (EditText) findViewById(R.id.editWeight);
        neck = (EditText) findViewById(R.id.EditNeck);
        waiste = (EditText) findViewById(R.id.editWaist);
    }

    public void update(View view) {

        String wristFinalString = wrist.getText().toString();
        String neckFinalString = neck.getText().toString();
        String waistFinalString = waiste.getText().toString();
       // String weightFinalString = weight.getText().toString();
        Data.recordGoal(this, wristFinalString, neckFinalString, waistFinalString);
    }
}
