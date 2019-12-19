## 学习hencoder 仍物线大佬

## [Android 开发进阶: 自定义 View 1-1 绘制基础](https://hencoder.com/ui-1-1/)
    Canvas.drawXXX() 和 Paint 基础
    drawXXX() 系列方法和 Paint 的基础掌握了，就能够应付简单的绘制需求。它们主要包括：
    
    Canvas 类下的所有 draw- 打头的方法，例如 drawCircle() drawBitmap()。
    Paint 类的几个最常用的方法。具体是：
    Paint.setStyle(Style style) 设置绘制模式
    Paint.setColor(int color) 设置颜色
    Paint.setStrokeWidth(float width) 设置线条宽度
    Paint.setTextSize(float textSize) 设置文字大小
    Paint.setAntiAlias(boolean aa) 设置抗锯齿开关
### Circle 
```
    paint.setColor(Color.BLUE);
    canvas.drawCircle(100,100,50,paint);
```
![圆形图片](image/Circle.jpg)

### React
```
    左上右下画笔 
    drawRect(float left, float top, float right, float bottom, Paint paint) 画矩形
```

### 速度差值器
```
     interpolators[0] = new AccelerateDecelerateInterpolator();
        interpolators[1] = new LinearInterpolator();
        interpolators[2] = new AccelerateInterpolator();
        interpolators[3] = new DecelerateInterpolator();
        interpolators[4] = new AnticipateInterpolator();
        interpolators[5] = new OvershootInterpolator();
        interpolators[6] = new AnticipateOvershootInterpolator();
        interpolators[7] = new BounceInterpolator();
        interpolators[8] = new CycleInterpolator(0.5f);
        interpolators[9] = PathInterpolatorCompat.create(interpolatorPath);
        interpolators[10] = new FastOutLinearInInterpolator();
        interpolators[11] = new FastOutSlowInInterpolator();
        interpolators[12] = new LinearOutSlowInInterpolator();


```