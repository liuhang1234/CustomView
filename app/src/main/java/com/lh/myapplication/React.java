package com.lh.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ComposeShader;
import android.graphics.LightingColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class React extends View {
    Paint paint = new Paint();

    Path path = new Path(); // 初始化 Path 对象

    Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
    String text1 = "三个月内你胖了";
    String text2 = "4.5";
    String text3 = "公斤";
    float measuredText1;
    float measuredText2;

    public React(Context context) {
        super(context);
    }

    public React(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public React(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    {
        paint1.setTextSize(60);
        paint2.setTextSize(120);
        paint2.setColor(Color.parseColor("#E91E63"));

        measuredText1 = paint1.measureText(text1);
        measuredText2 = paint2.measureText(text2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        Shader shader = new LinearGradient(100, 100, 500, 500, Color.parseColor("#E91E63"),
//                Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
//        paint.setShader(shader);
//
//
//        canvas.drawCircle(300, 300, 200, paint);

//        Shader shader = new RadialGradient(300, 300, 200, Color.parseColor("#E91E63"),
//                Color.parseColor("#2196F3"), Shader.TileMode.MIRROR);
//        paint.setShader(shader);
//


        //扫描渐变
//        Shader shader = new SweepGradient(300, 300, Color.parseColor("#E91E63"),
//                Color.parseColor("#2196F3"));
//        paint.setShader(shader);
//

//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
//        Shader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
//        paint.setShader(shader);


        // 第一个 Shader：头像的 Bitmap
//        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.test);
//        Shader shader1 = new BitmapShader(bitmap1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

// 第二个 Shader：从上到下的线性渐变（由透明到黑色）
//        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
//        Shader shader2 = new BitmapShader(bitmap2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
//
//// ComposeShader：结合两个 Shader
//        Shader shader = new ComposeShader(shader1, shader2, PorterDuff.Mode.ADD);

//        ColorFilter lightingColorFilter = new LightingColorFilter(0xffffff, 0xF0F000);
//        paint.setColorFilter(lightingColorFilter);
//        paint.setShader(shader1);


//
//        canvas.drawCircle(300, 300, 300, paint);
//
//        canvas.drawCircle(300, 300, 200, paint);
//
//        canvas.drawCircle(300, 300, 200, paint);
//
//        canvas.drawCircle(300, 300, 200, paint);
//        paint.setColor(Color.RED);
//        paint.setStyle(Paint.Style.STROKE);
//        path.moveTo(0,300);
//        paint.setStrokeWidth(1);
//
//        path.lineTo(300, 300);                      // lineTo
//        path.lineTo(400, 300);                      // lineTo
//        path.lineTo(500, 500);                      // lineTo
//        paint.setStrokeJoin(Paint.Join.ROUND);
//        paint.setTextSize(50);
//
//        canvas.drawPath(path,paint);
//        canvas.drawTextOnPath("哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈",path,30,0,paint);


        canvas.drawText(text1, 50, 200, paint1);
        canvas.drawText(text2, 50 + measuredText1, 200, paint2);
        canvas.drawText(text3, 50 + measuredText1 + measuredText2, 200, paint1);

    }
}
