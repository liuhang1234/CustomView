package com.lh.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Circle extends View {

    Paint paint = new Paint();
    Path path = new Path(); // 初始化 Path 对象
    public Circle(Context context) {
        super(context);
    }

    public Circle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Circle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    float[] points = {0, 0, 50, 50, 50, 100, 100, 50, 100, 100, 150, 50, 150, 100};
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);// 抗锯齿
        paint.setStyle(Paint.Style.STROKE);//描边 划线的 画笔
//        paint.setStrokeWidth(10);// 描边的宽度
//        canvas.drawCircle(100,100,50,paint);
//        canvas.drawRect(100,200,500,500,paint);
//        paint.setStrokeCap(Paint.Cap.SQUARE);
//        canvas.drawPoint(20,20,paint);
        canvas.drawPoints(points,paint);
        //椭圆
//        canvas.drawOval( 50, 100, 200, 300,  paint);
        //带圆角 左上右下 x轴圆角 y轴圆角
//        canvas.drawRoundRect(20,100,200,300,10,80,paint);

        paint.setStyle(Paint.Style.FILL); // 填充模式
        // 画弧形 左上右下
//        canvas.drawArc(0, 100, 400, 500, 0, 300, false, paint); // 绘制扇形
//        canvas.drawArc(200, 100, 700, 500, 20, 140, false, paint); // 绘制弧形
//        paint.setStyle(Paint.Style.STROKE); // 画线模式
//        canvas.drawArc(200, 100, 700, 500, 180, 60, false, paint); // 绘制不封口的弧形

        // 划线
//        path.addArc(200, 200, 400, 400, -225, 225);
////        path.arcTo(400, 200, 600, 400, 0, 270, true);
//        path.lineTo(400, 542);

        //两个交叉的圆
//        path.addCircle(300,300,150, Path.Direction.CW);
//        path.addCircle(500,300,150, Path.Direction.CCW);


//        paint.setStyle(Paint.Style.STROKE);
//        path.lineTo(200, 200); // 由当前位置 (0, 0) 向 (200, 200) 画一条直线
//        path.rLineTo(200, -50); // 由当前位置 (200, 200) 向右方 dx 100  dy 50 像素的位置画一条直线

//        path.moveTo(0, 250); // 移动到起始点
//        path.cubicTo(125, 100, 250, 150,200,300);// 前两个 是控制点 终点
////        path.rQuadTo(-175, 100, -300, 0);// 前两个 是控制点 终点
////        path.rQuadTo(300,600,100,500);
////        path.rQuadTo(50,50,100,100);
//
//
//        path.close();
        canvas.drawArc(50,50,250,250,180,-90,true,paint);

        canvas.drawArc(50,40,250,240,190,90,true,paint);
        canvas.drawPath(path,paint);
    }
}
