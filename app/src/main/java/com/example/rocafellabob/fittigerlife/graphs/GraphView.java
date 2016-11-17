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
import android.util.Log;
import android.view.View;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thorn
 */
public class GraphView extends View {

    Paint paint;
    float[] datapoints;
    int w;
    int h;

    /*
        give it a context (this) and an array of points to draw a graph
    */
    public GraphView(Context context, float[] points) {
        super(context);
        //
        datapoints = points;
        // default paint settings
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setTextAlign(Align.CENTER);
    }
    
    // give it a paint to customize
    public GraphView(Context context, float[] points, Paint pnt) {
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
        Log.d("TEST", w + " " + h);
        super.onSizeChanged(w, h, oldw, oldh);
    }
    
    protected static float floatDateToDays(float date) {
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
        String sDate = Float.toString(date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        float dayDate = 0;
        try {
            Date dDate = sdf.parse(sDate); // get date object from the string
            float msDate = dDate.getTime(); // turn into milliseconds from 1970
            dayDate = msDate / 86400000; // turn into number of days bc 86400000 ms in a day
        } catch (Exception e) {
            Log.d("ERR", e.getMessage());
        }
        return dayDate;
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);
        // axis assuming horizontal phone
        float[] axiss = {
            10, h,    // bottom left to
            10, 10,                    // top left
            10, 10,                    // top left to
            w, 10      // top right
        };
        canvas.drawLines(axiss, paint);
        
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
        float max_x = 0; // assume max is 0, better to use min value for float aka negative max but oh well
        float max_y = 0;
        float min_x = Float.MAX_VALUE; // start at max so we can work our way down
        // these are the numbers associated with whatever you're graphing
        for(int i = 0; i < datapoints.length; i = i+2) {
            max_y = Math.max(max_y, datapoints[i]); // find max for scaling
        }
        // these are the dates (over time)
        for(int i = 1; i < datapoints.length; i = i+2) {
            datapoints[i] = floatDateToDays(datapoints[i]);
            min_x = Math.min(min_x, datapoints[i]);
            max_x = Math.max(max_x, datapoints[i]); // find max for scaling
        }
        // subtract min from everything so it starts from 0
        for(int i = 1; i < datapoints.length; i = i+2) {
            datapoints[i] = datapoints[i] - min_x;
        }
        max_x = max_x - min_x; // also subtract from the max
        Log.d("max", max_x + " " + max_y);
        for(int i = 0; i < datapoints.length; i = i+2) { // this fixes all the y values (index 0, 2, 4, 8 etc.) remember they are reversed
            datapoints[i] = datapoints[i] / max_y * (w - 10) + 10; // + 10 and - 10 for axis
        }
        for(int i = 1; i < datapoints.length; i = i+2) { // same for x values
            datapoints[i] = datapoints[i] / max_x * (h - 10) + 10; // + 10 and - 10 for axis
        }
        canvas.drawLines(datapoints, paint);
//        Path path = new Path();
//        canvas.drawPath(path, paint);
//        canvas.drawText(canvas.getWidth() + "", 200, 200, paint);
//        
//        path.moveTo(datapoints[0].x, datapoints[0].y);
//        for (int i = 1; i < datapoints.length; i++) {
//            // writing the numbers for reference
//            canvas.drawText(datapoints[i].x + "," + datapoints[i].y, datapoints[i].x, datapoints[i].y, paint);
//            // actual line
//            path.lineTo(datapoints[i].x, datapoints[i].y);
//        }
//        canvas.drawPath(path, paint);
//    }
    }
}
