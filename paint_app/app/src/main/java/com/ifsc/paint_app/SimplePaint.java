package com.ifsc.paint_app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SimplePaint extends View {
    List<Path> paths;
    List<Paint> paints;
    Paint currentPaint;
    Path currentPath;
    ColorDrawable currentColor;
    Shape currentShape;

    public SimplePaint(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);

        paths = new ArrayList<>();
        paints = new ArrayList<>();

        currentColor = new ColorDrawable();
        currentColor.setColor(Color.BLACK);
        currentShape = Shape.Line;

        initializeLayer();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < paints.size(); i++) {
            canvas.drawPath(paths.get(i), paints.get(i));
        }

        canvas.drawPath(currentPath, currentPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x, y;
        x = motionEvent.getX();
        y = motionEvent.getY();

        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_BUTTON_PRESS:
            case MotionEvent.ACTION_DOWN:
                currentPath.moveTo(x, y);
                currentPath.lineTo(x, y);
                break;
            case MotionEvent.ACTION_MOVE:
                currentPath.lineTo(x, y);
                break;
            case MotionEvent.ACTION_UP:
                currentPath.lineTo(x, y);
                initializeLayer();
                break;
            default:
                break;
        }
        invalidate();

        return true;
    }

    public void setColorPaint(int color) {
        currentColor.setColor(color);
        currentPaint.setColor(currentColor.getColor());
    }

    private void initializeLayer() {
        currentPaint = new Paint();
        currentPath = new Path();
        paths.add(currentPath);
        paints.add(currentPaint);

        currentPaint.setStyle(Paint.Style.STROKE);
        currentPaint.setColor(currentColor.getColor());
        currentPaint.setStrokeWidth(20);
    }

    public void clearDrawing() {
        paints = new ArrayList<>();
        paths = new ArrayList<>();
        initializeLayer();

        invalidate();
    }

    public void useLine() {
        currentShape = Shape.Line;
    }

    public void useSquare() {
        currentShape = Shape.Square;
    }

    public void useCircle() {
        currentShape = Shape.Circle;
    }
}