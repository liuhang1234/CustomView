package com.lh.myapplication.anim2;

import android.animation.ArgbEvaluator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PointFEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

import com.lh.myapplication.R;

public class Sample01ArgbEvaluatorLayout extends RelativeLayout {
    Sample01ArgbEvaluatorView view;
    Button animateBt;

    public Sample01ArgbEvaluatorLayout(Context context) {
        super(context);
    }

    public Sample01ArgbEvaluatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample01ArgbEvaluatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        view = (Sample01ArgbEvaluatorView) findViewById(R.id.objectAnimatorView);
        animateBt = (Button) findViewById(R.id.animateBt);

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                ObjectAnimator animator = ObjectAnimator.ofInt(view, "color", 0xffff0000, 0xff00ff00);
////                animator.setEvaluator(new ArgbEvaluator());
//                animator.setEvaluator(new HsvEvaluator());
//                animator.setInterpolator(new LinearInterpolator());
//                animator.setDuration(2000);
//                animator.start();

//                ObjectAnimator animator = ObjectAnimator.ofObject(view, "position",
//                        new PointFEvaluator(), new PointF(0, 0), new PointF(1, 1));
//                animator.setInterpolator(new LinearInterpolator());
//                animator.setDuration(1000);
//                animator.start();


                Keyframe keyframe1 = Keyframe.ofFloat(0, 0); // 开始：progress 为 0
                Keyframe keyframe2 = Keyframe.ofFloat(0.5f, 100); // 进行到一半是，progres 为 100
                Keyframe keyframe3 = Keyframe.ofFloat(1, 80); // 结束时倒回到 80
                PropertyValuesHolder holder = PropertyValuesHolder.ofKeyframe("progress", keyframe1, keyframe2, keyframe3);

                ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(view, holder);
                animator.setDuration(2000);
                animator.setInterpolator(new FastOutSlowInInterpolator());
                animator.start();

            }
        });
    }

    private class HsvEvaluator implements TypeEvaluator<Integer> {
        float[] startHsv = new float[3];
        float[] endHsv = new float[3];
        float[] outHsv = new float[3];

        @Override
        public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
            // 把 ARGB 转换成 HSV
            Color.colorToHSV(startValue, startHsv);
            Color.colorToHSV(endValue, endHsv);

            // 计算当前动画完成度（fraction）所对应的颜色值
            if (endHsv[0] - startHsv[0] > 180) {
                endHsv[0] -= 360;
            } else if (endHsv[0] - startHsv[0] < -180) {
                endHsv[0] += 360;
            }
            outHsv[0] = startHsv[0] + (endHsv[0] - startHsv[0]) * fraction;
            if (outHsv[0] > 360) {
                outHsv[0] -= 360;
            } else if (outHsv[0] < 0) {
                outHsv[0] += 360;
            }
            outHsv[1] = startHsv[1] + (endHsv[1] - startHsv[1]) * fraction;
            outHsv[2] = startHsv[2] + (endHsv[2] - startHsv[2]) * fraction;

            // 计算当前动画完成度（fraction）所对应的透明度
            int alpha = startValue >> 24 + (int) ((endValue >> 24 - startValue >> 24) * fraction);

            // 把 HSV 转换回 ARGB back
            return Color.HSVToColor(alpha, outHsv);
        }
    }

}
