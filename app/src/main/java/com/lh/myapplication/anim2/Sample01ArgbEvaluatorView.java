package com.lh.myapplication.anim2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.lh.myapplication.Utils;

import static com.lh.myapplication.Utils.dpToPixel;

public class Sample01ArgbEvaluatorView extends View {

//    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
//
//    int color = 0xffff0000;


//    public static final float RADIUS = Utils.dpToPixel(20);
//
//    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
//
//    PointF position = new PointF();



    final float radius = dpToPixel(80);

    float progress = 0;
    RectF arcRectF = new RectF();

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);


    public Sample01ArgbEvaluatorView(Context context) {
        super(context);
    }

    public Sample01ArgbEvaluatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample01ArgbEvaluatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    public int getColor() {
//        return color;
//    }
//
//    public void setColor(int color) {
//        this.color = color;
//        invalidate();
//    }


    {
        paint.setColor(Color.parseColor("#009688"));

        paint.setTextSize(dpToPixel(40));
        paint.setTextAlign(Paint.Align.CENTER);
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
        invalidate();
    }


//    public PointF getPosition() {
//        return position;
//    }

//    public void setPosition(PointF position) {
//        if (position != null) {
//            this.position.set(position);
//            invalidate();
//        }
//    }


    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        int width = getWidth();
//        int height = getHeight();
//
//        paint.setColor(color);
//        canvas.drawCircle(width / 2, height / 2, width / 6, paint);


//        float innerPaddingLeft = RADIUS * 1;
//        float innterPaddingRight = RADIUS * 1;
//        float innterPaddingTop = RADIUS * 1;
//        float innterPaddingBottom = RADIUS * 3;
//        float width = getWidth() - innerPaddingLeft - innterPaddingRight - RADIUS * 2;
//        float height = getHeight() - innterPaddingTop - innterPaddingBottom - RADIUS * 2;
//
//        canvas.drawCircle(innerPaddingLeft + RADIUS + width * position.x, innterPaddingTop + RADIUS + height * position.y, RADIUS, paint);



        float centerX = getWidth() / 2;
        float centerY = getHeight() / 2;

        paint.setColor(Color.parseColor("#E91E63"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(dpToPixel(15));
        arcRectF.set(centerX - radius, centerY - radius, centerX + radius, centerY + radius);
        canvas.drawArc(arcRectF, 135, progress * 2.7f, false, paint);

        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText((int) progress + "%", centerX, centerY - (paint.ascent() + paint.descent()) / 2, paint);

    }
}
