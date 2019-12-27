package com.lh.myapplication.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class BeiSaierView extends View {
    private Paint mPaint = new Paint();
    public BeiSaierView(Context context) {
        super(context);
    }

    public BeiSaierView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BeiSaierView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
        Path path = new Path();
        path.moveTo(100,300);
        path.quadTo(200,200,300,300);
        path.quadTo(400,400,500,300);
        canvas.drawPath(path,mPaint);
    }
}
