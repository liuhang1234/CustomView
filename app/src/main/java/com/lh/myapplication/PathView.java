package com.lh.myapplication;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class PathView extends View {
    private Paint mPaint;
    private Path mDstPath;
    private Path mCircle;
    private PathMeasure mPathMeasure;
    private float mCurrentValue = 0;
    private Bitmap mArrawBitmap;
    public PathView(Context context) {
        super(context);init(context);
    }

    public PathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context){
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(4);
        mPaint.setColor(Color.BLACK);
        mArrawBitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.arraw);
        mDstPath = new Path();
        mCircle = new Path();
        mCircle.addCircle(300,300,150, Path.Direction.CW);
        mPathMeasure = new PathMeasure(mCircle,true);
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setDuration(2000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mCurrentValue = (float) animation.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.start();
    }
    float[] pos = new float[2];
    float[] tan = new float[2];
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        float length = mPathMeasure.getLength();
        float stop = length * mCurrentValue;
        float start = (float)(stop - ((0.5 - Math.abs(mCurrentValue - 0.5))*length));

        mDstPath.reset();
        mPathMeasure.getSegment(start,stop,mDstPath,true);
        mPathMeasure.getPosTan(stop,pos,tan);
        float degress = (float)(Math.atan2(tan[1],tan[0])*180/Math.PI);
        Matrix matrix = new Matrix();
        matrix.postRotate(degress,mArrawBitmap.getWidth()/2,mArrawBitmap.getHeight()/2);
        matrix.postTranslate(pos[0]-mArrawBitmap.getWidth()/2,pos[1]-mArrawBitmap.getHeight()/2);
        canvas.drawPath(mDstPath,mPaint);

        canvas.drawBitmap(mArrawBitmap,matrix,mPaint);

    }
}
