package com.lh.myapplication.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class GestureView extends View {
    private Paint mPaint = new Paint();
    private Path mPath = new Path();
    public GestureView(Context context) {
        super(context);
    }

    public GestureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public GestureView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        canvas.drawPath(mPath,mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:{
                mPath.moveTo(event.getX(),event.getY());
                return true;
            }
            case MotionEvent.ACTION_MOVE:{
                mPath.lineTo(event.getX(),event.getY());
                postInvalidate();
                break;
            }
            default:
                break;


        }
        return super.onTouchEvent(event);
    }

}
