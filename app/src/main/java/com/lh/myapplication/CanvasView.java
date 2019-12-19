package com.lh.myapplication;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;

public class CanvasView extends View {
//    float left = 30,right = 130,top = 50,bottom = 150;
//    float [] pointsSrc = {left, top, right, top, left, bottom, right, bottom};
//    float [] pointsDst = {left - 10, top + 50, right + 120, top - 90, left + 20, bottom + 30, right + 20, bottom + 60};
//    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
//    Camera camera = new Camera();
//    Bitmap bitmap;
//    Point point1 = new Point(100, 100);
//    Point point2 = new Point(100, 400);
//    Matrix matrix = new Matrix();


//    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
//    Bitmap bitmap;
//    Point point = new Point(200, 50);
//    Camera camera = new Camera();
//    Matrix matrix = new Matrix();
//    int degree;
//    ObjectAnimator animator = ObjectAnimator.ofInt(this, "degree", 0, 360);


    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Camera camera = new Camera();
    int degree;
    ObjectAnimator animator = ObjectAnimator.ofInt(this, "degree", 0, 180);

    public CanvasView(Context context) {
        super(context);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
//        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() * 2, bitmap.getHeight() * 2, true);
//        bitmap.recycle();
//        bitmap = scaledBitmap;
//
//        animator.setDuration(5000);
//        animator.setInterpolator(new LinearInterpolator());
//        animator.setRepeatCount(ValueAnimator.INFINITE);
//
//        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
//        float newZ = - displayMetrics.density * 6;
//        camera.setLocation(0, 0, newZ);


        animator.setDuration(2500);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);

    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        Matrix matrix = new Matrix();
//
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
//
////        matrix.reset();
////        matrix.setPolyToPoly(pointsSrc, 1, pointsDst, 1, 4);
////
////        canvas.save();
////        canvas.concat(matrix);
////        canvas.drawBitmap(bitmap, 100,100, paint);
////        canvas.restore();
//        canvas.save();
//
////        camera.save();
////        camera.rotateY(-50); // 旋转 Camera 的三维空间
////        camera.applyToCanvas(canvas); // 把旋转投影到 Canvas
////        camera.restore(); // 恢复 Camera 的状态
////        canvas.drawBitmap(bitmap, 100, 100, paint);
//        canvas.restore();

//        int bitmapWidth = bitmap.getWidth();
//        int bitmapHeight = bitmap.getHeight();
//
//        canvas.save();
//        canvas.rotate(180, point1.x + bitmapWidth / 2, point1.y + bitmapHeight / 2);
//        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
//        canvas.restore();
//
//        canvas.save();
//        canvas.rotate(45, point2.x + bitmapWidth / 2, point2.y + bitmapHeight / 2);
//        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
//        canvas.restore();

//        int bitmapWidth = bitmap.getWidth();
//        int bitmapHeight = bitmap.getHeight();
//
//        canvas.save();
//        matrix.reset();
////        matrix.postScale(1.3f, 1.3f, point1.x + bitmapWidth / 2, point1.y + bitmapHeight / 2);
//        matrix.postSkew(0, 0.5f, point1.x + bitmapWidth / 2, point1.y + bitmapHeight / 2);
//        canvas.concat(matrix);
//        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
//        canvas.restore();
//
//        canvas.save();
//        matrix.reset();
////        matrix.postScale(1.6f, 1.6f, point2.x + bitmapWidth / 2, point2.y + bitmapHeight / 2);
//        matrix.postSkew(-0.5f, 0, point2.x + bitmapWidth / 2, point2.y + bitmapHeight / 2);
//        canvas.concat(matrix);
//        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
//        canvas.restore();

//
//        int bitmapWidth = bitmap.getWidth();
//        int bitmapHeight = bitmap.getHeight();
//        int center1X = point1.x + bitmapWidth / 2;
//        int center1Y = point1.y + bitmapHeight / 2;
//        int center2X = point2.x + bitmapWidth / 2;
//        int center2Y = point2.y + bitmapHeight / 2;
//
//        camera.save();
//        matrix.reset();
//        camera.rotateX(30);
//        camera.getMatrix(matrix);
//        camera.restore();
//        matrix.preTranslate(-center1X, -center1Y);
//        matrix.postTranslate(center1X, center1Y);
//        canvas.save();
//        canvas.concat(matrix);
//        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
//        canvas.restore();
//
//        camera.save();
//        matrix.reset();
//        camera.rotateY(30);
//        camera.getMatrix(matrix);
//        camera.restore();
//        matrix.preTranslate(-center2X, -center2Y);
//        matrix.postTranslate(center2X, center2Y);
//        canvas.save();
//        canvas.concat(matrix);
//        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
//        canvas.restore();

//        int bitmapWidth = bitmap.getWidth();
//        int bitmapHeight = bitmap.getHeight();
//        int centerX = point.x + bitmapWidth / 2;
//        int centerY = point.y + bitmapHeight / 2;
//
//        camera.save();
//        matrix.reset();
//        camera.rotateX(degree);
//        camera.getMatrix(matrix);
//        camera.restore();
//        matrix.preTranslate(-centerX, -centerY);
//        matrix.postTranslate(centerX, centerY);
//        canvas.save();
//        canvas.concat(matrix);
//        canvas.drawBitmap(bitmap, point.x, point.y, paint);
//        canvas.restore();


        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int x = centerX - bitmapWidth / 2;
        int y = centerY - bitmapHeight / 2;

        // 第一遍绘制：上半部分
//        canvas.save();
//        canvas.clipRect(0, 0, getWidth(), centerY);
//        canvas.drawBitmap(bitmap, x, y, paint);
//        canvas.restore();

        // 第二遍绘制：下半部分
        canvas.save();
//
        if (degree < 90) {
            canvas.clipRect(0, centerY, getWidth(), getHeight());
        } else {
            canvas.clipRect(0, 0, getWidth(), centerY);
        }
        camera.save();
        camera.rotateX(degree);
        canvas.translate(centerX, centerY);
        camera.applyToCanvas(canvas);
        canvas.translate(-centerX, -centerY);
        camera.restore();

        canvas.drawBitmap(bitmap, x, y, paint);
        canvas.restore();

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        animator.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        animator.end();
    }

    @SuppressWarnings("unused")
    public void setDegree(int degree) {
        this.degree = degree;
        invalidate();
    }

}
