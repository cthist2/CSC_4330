package com.example.rocafellabob.fittigerlife.util;

import java.text.SimpleDateFormat;

/**
 * DataConsts.java
 * constants for constant constants and easy access
 * 11/16/16     Thomas      create file
 * 11/20/16     Spencer     Added the new current_measurement.csv
 */
public final class DataConsts {

    public static final String comma = ",";
    public static final String newline = "\n";
    public static final String profile_csv = "Profile.csv";
    public static final String measurements_csv = "Measurements.csv";
    public static final String cardio_csv = "Cardio_Storage.csv";
    public static final String calories_csv = "Calories_Storage.csv";
    public static final String weights_csv = "Weights_Storage.csv";
    public static final String current_measurements_csv = "Current_Measurements.csv";
    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    public static final SimpleDateFormat year = new SimpleDateFormat("yyyy");
    public static final SimpleDateFormat month = new SimpleDateFormat("MM");
    public static final SimpleDateFormat day = new SimpleDateFormat("dd");
}
