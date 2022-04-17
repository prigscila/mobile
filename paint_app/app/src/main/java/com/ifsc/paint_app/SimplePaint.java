package com.ifsc.paint_app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class SimplePaint extends View {
    Paint paint;
    Path path;

    public SimplePaint(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);

        paint = new Paint();
        path = new Path();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float lx, ly;
        lx = motionEvent.getX();
        ly = motionEvent.getY();

        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_BUTTON_PRESS:
                path.moveTo(lx, ly);
                path.lineTo(lx, ly);
                break;
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
                path.lineTo(lx, ly);
                break;
            default:
                break;
        }
        invalidate();

        return true; //super.onTouchEvent(motionEvent);
    }

    public void setColorPaint(int color) {
        paint.setColor(color);
    }
}