package com.ikarosu.mypaintapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

public class MyRect {
    private Paint mPaint = new Paint();
    Canvas canvas;

    public MyRect(Canvas canvas){
        this.canvas = canvas;
    }

    public void paint(){
        canvas.drawRect(100,100,200,300,mPaint);
    }
}
