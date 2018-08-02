package com.ikarosu.mypaintapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
//import android.util.AttributeSet;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {
    private Paint mPaint;

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        canvas.drawText("Hello Custom View!", 50, 50, mPaint);
//        mPaint.setColor(Color.argb(255, 125, 125, 255));
//        canvas.drawRect(100, 100, 200, 300, mPaint);
//        canvas.drawRect(300, 100, 400, 300, mPaint);
//        canvas.drawRect(600, 100, 700, 300, mPaint);
//        canvas.drawCircle(150, 150, 25, mPaint); // 半径25
        // ここで vector つくって描画，drawingのオブジェクトつくって打ち込む
        // 主に描画を担当
        // Oval状態→タッチ→

        // 背景，半透明
        canvas.drawColor(Color.argb(125,0,0,255));

        // 円
        mPaint.setColor(Color.argb(255, 68, 125, 255));
        mPaint.setStrokeWidth(30);
        mPaint.setAntiAlias(true);
        // (x1,y1,r,paint) 中心x１座標，中心ｙ１座標,r半径
        canvas.drawCircle(450,450,100,mPaint);

        // 短形
        mPaint.setColor(Color.argb(255,255,0,255));
        mPaint.setStrokeWidth(10);
        mPaint.setAntiAlias(true);
        // (x1,y1,x2,y2,paint)左上の座標(x1,y1)，右下の座標(x2,y2)
        canvas.drawRect(180,180,450,380,mPaint);

        // 線
        mPaint.setStrokeWidth(15);
        mPaint.setColor(Color.argb(255,0,255,120));
        // (x1,y1,x2,y2,paint) 始点の座標，終点の座標
        canvas.drawLine(350,850,750,630,mPaint);
    }
}

