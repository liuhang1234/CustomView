package com.lh.myapplication.activity;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class AlipayView extends View {

    private Paint mPaint = new Paint();
    private  Path mDstPath ;
    private  Path mCirclePath ;
    private PathMeasure mPathMeasure ;
    private float mCentX = 300;
    private float mCentY = 300;
    private float mRadius = 150;
    private float mCurAnimValue = 0;
    public AlipayView(Context context) {
        super(context);
        init(context);
    }



    public AlipayView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public AlipayView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    private void init(Context context) {
        mDstPath = new Path();
        mCirclePath = new Path();
        mPaint.setStyle(Paint.Style.STROKE);
        mCirclePath.addCircle(mCentX,mCentY,mRadius, Path.Direction.CW);
        mCirclePath.moveTo(mCentX-mRadius/2,mCentY);
        mCirclePath.lineTo(mCentX,mCentY+mRadius/2);
        mCirclePath.lineTo(mCentX+mRadius/2,mCentY-mRadius/3);
        mPathMeasure = new PathMeasure(mCirclePath,false);
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 2);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mCurAnimValue = (float) animation.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.setDuration(4000);

        valueAnimator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        Log.d("liuhang","mCurAnimValue = "+mCurAnimValue);
        if (mCurAnimValue<1){
            float stop = mPathMeasure.getLength() *mCurAnimValue;
            mPathMeasure.getSegment(0,stop,mDstPath,true);
        } else if (mCurAnimValue == 1){
            mPathMeasure.getSegment(0,mPathMeasure.getLength(),mDstPath,true);
            boolean b = mPathMeasure.nextContour();
            Log.d("liuhang","b = "+b);
        } else {
            float stop = mPathMeasure.getLength()*(mCurAnimValue -1);
            mPathMeasure.getSegment(0,stop,mDstPath,true);
        }
        canvas.drawPath(mDstPath,mPaint);
    }
}
