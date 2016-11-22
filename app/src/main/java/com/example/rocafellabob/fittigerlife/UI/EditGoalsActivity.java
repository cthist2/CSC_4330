package com.example.rocafellabob.fittigerlife.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.rocafellabob.fittigerlife.UI.interfaces.*;
import com.example.rocafellabob.fittigerlife.data.Data;

/**
 * EditGoalsActivity.java
 * edit fitness goals activity
 * Date:        Person:     Reason:
 * 11/8/16      Spencer     First edition changes to Storage 
 * 11/11/16     Spencer     Fixed storage and insure correct recording
 * 11/16/16     Thomas      move data processing to separate file (huge refactoring)
 */
public class EditGoalsActivity extends AppCompatActivity implements EditActivity, UIInterface {

    EditText weight, wrist, neck, waiste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_goals);
        loadElements();
    }

    @Override
    public void loadElements() {
        wrist = (EditText) findViewById(R.id.editWrist);
        weight = (EditText) findViewById(R.id.editWeight);
        neck = (EditText) findViewById(R.id.EditNeck);
        waiste = (EditText) findViewById(R.id.editWaist);
    }

    @Override
    public void update(View view) {
        String wristFinalString = wrist.getText().toString();
        String neckFinalString = neck.getText().toString();
        String waistFinalString = waiste.getText().toString();
        String weightFinalString = weight.getText().toString();
        Data.recordGoal(this, wristFinalString, neckFinalString, waistFinalString, weightFinalString);
    }
}
