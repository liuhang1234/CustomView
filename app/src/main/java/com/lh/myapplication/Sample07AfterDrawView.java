package com.lh.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

public class Sample07AfterDrawView extends AppCompatImageView {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Sample07AfterDrawView(Context context) {
        super(context);
    }

    public Sample07AfterDrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample07AfterDrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    {
        paint.setTextSize(60);
    }
//    @Override
//    public void draw(Canvas canvas) {
//        super.draw(canvas);
//
//        paint.setColor(Color.parseColor("#f44336"));
//        canvas.drawRect(0, 40, 200, 120, paint);
//        paint.setColor(Color.WHITE);
//        canvas.drawText("New", 20, 100, paint);
//    }

    @Override
    public void onDrawForeground(Canvas canvas) {
        paint.setColor(Color.parseColor("#f44336"));
        canvas.drawRect(0, 40, 200, 120, paint);
        paint.setColor(Color.WHITE);
        canvas.drawText("New", 20, 100, paint);

        super.onDrawForeground(canvas);
    }
}
