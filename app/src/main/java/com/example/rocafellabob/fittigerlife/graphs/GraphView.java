/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.rocafellabob.fittigerlife.graphs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;

import static com.example.rocafellabob.fittigerlife.util.DataConsts.*;

import android.view.View;

import java.util.Date;

/**
 * Graph.java
 * graphing logic
 * 11/16/16     Thomas      create file
 * 11/22/2016   Thomas      draw the center value
 */
public class GraphView extends View {

    Paint paint;
    double[] datapoints;
    int w;
    int h;

    /**
     * parameterized constructor that creates a graph
     * 
     * @param context the screen to take over
     * @param points the points to graph
     */
    public GraphView(Context context, double[] points) {
        super(context);
        //
        datapoints = points;
        // default paint settings
        paint = new Paint();
        paint.setColor(Color.MAGENTA);
        paint.setStrokeWidth(3);
        paint.setStyle(Paint.Style.STROKE);
        paint.setTextAlign(Align.CENTER);
        paint.setTextSize(30);
    }

    /**
     * another parameterized constructor that allows custom paint
     * 
     * @param context the screen to take over
     * @param points the points to graph
     * @param pnt the paint to use
     */
    public GraphView(Context context, double[] points, Paint pnt) {
        super(context);
        //
        datapoints = points;
        // default paint settings
        paint = new Paint();
        paint.set(pnt);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.w = w;
        this.h = h;
//        Log.d("TEST", w + " " + h);
        super.onSizeChanged(w, h, oldw, oldh);
    }

    /**
     * convert a date to the number of days from 1970-1-1 (unix time)
     * 
     * @param date the date to convert
     * @return the number of days from 1970-1-1
     */
    protected static double doubleDateToDays(double date) {
        // assume that the x points (actually y points) are date format yyyymmdd
        // convert them to days from 1970
        /*
                try {
            Date startDate2 = df.parse(startDate);
            System.out.println(startDate2.getTime() / 86400000); // days from 1970 or whatever
            Date startDate4 = df.parse(startDate3);
            System.out.println(startDate4.getTime() / 86400000); // days from 1970 or whatever
            System.out.println(startDate4.getTime() / 86400000 - startDate2.getTime() / 86400000); // 1 day apart
            // milliseconds in a day = 86400000
         */
        String sDate = String.format("%.0f", date);
        float dayDate = 0;
        try {
            Date dDate = sdf.parse(sDate); // get date object from the string
            float msDate = dDate.getTime(); // turn into milliseconds from 1970
            dayDate = msDate / 86400000; // turn into number of days bc 86400000 ms in a day
        } catch (Exception e) {
//            Log.d("ERR", e.getMessage());
        }
        return dayDate;
    }
        
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawColor(Color.BLACK);
        // axis assuming horizontal phone
        float[] axiss = {
            10, h, // bottom left to
            10, 10, // top left
            10, 10, // top left to
            w, 10 // top right
        };

        // scaling logic
        /*
            first thing to consider - because its horizontal
                x governs y
                y governs x     example: the point (100, 200) is graphed by (200, 100)
                so make sure you put the points in as {y1, x1, y2, x2 etc.}
            is that really it??
        
            second thing to consider
                we have to scale the points to fit the graph
                h = height of the graph = x so all we do is take the largest value and divide
                w = width = y so all we have to do is take the largest and divide
         */
        double max_x = 0; // assume max is 0, better to use min value for float aka negative max but oh well
        double max_y = 0;
        double min_x = Double.MAX_VALUE; // start at max so we can work our way down
        // these are the numbers associated with whatever you're graphing
        for (int i = 0; i < datapoints.length; i = i + 2) {
            max_y = Math.max(max_y, datapoints[i]); // find max for scaling
        }
        // these are the dates (over time)
        for (int i = 1; i < datapoints.length; i = i + 2) {
            datapoints[i] = doubleDateToDays(datapoints[i]);
            min_x = Math.min(min_x, datapoints[i]); // find min for scaling
            max_x = Math.max(max_x, datapoints[i]); // find max for scaling
        }
        // subtract min from everything so it starts from 0
        for (int i = 1; i < datapoints.length; i = i + 2) {
            datapoints[i] = datapoints[i] - min_x;
        }
        
        int tmp = paint.getColor();
        paint.setColor(Color.BLACK);
        canvas.drawLines(axiss, paint); // black axis then reassign
        canvas.drawLine(w/2, 0, w/2, h, paint); // draw middle line
        paint.setColor(tmp);

        canvas.save();
        canvas.rotate(90);
        canvas.drawText(String.format("%.0f", max_y / 2), 40, -w/2 + 10, paint); // draw the middle value
        canvas.restore();
        
        max_x = max_x - min_x; // also subtract from the max
//        Log.d("max", max_x + " " + max_y);
        for (int i = 0; i < datapoints.length; i = i + 2) { // this fixes all the y values (index 0, 2, 4, 8 etc.) remember they are reversed
            datapoints[i] = datapoints[i] / max_y * (w - 10) + 10; // + 10 and - 10 for axis
        }
        for (int i = 1; i < datapoints.length; i = i + 2) { // same for x values
            datapoints[i] = datapoints[i] / max_x * (h - 10) + 10; // + 10 and - 10 for axis
        }
        float[] temp = new float[datapoints.length];
        for (int i = 0; i < datapoints.length; i++) {
            temp[i] = (float) datapoints[i];
        }
        canvas.drawLines(temp, paint); // and finally draw
    }
}
