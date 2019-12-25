package com.lh.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.lh.myapplication.R;
import com.lh.myapplication.evaluator.CharEvaluator;
import com.lh.myapplication.evaluator.FallingBallEvaluator;
import com.lh.myapplication.interpolator.CustomLinearInterpolator;

public class AnimActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        Button move = findViewById(R.id.move);
        findViewById(R.id.btn).setOnClickListener(v -> {

//            ValueAnimator valueAnimator = ValueAnimator.ofInt(100, 400);
            ValueAnimator valueAnimator = ValueAnimator.ofObject(new CharEvaluator(),new Character('a'),
                    new Character('z'));
            valueAnimator.setDuration(1000);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){

                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
//                    Integer animatedValue = (Integer)animation.getAnimatedValue();
//                    move.layout(move.getLeft(),animatedValue,move.getRight(),animatedValue+move.getHeight());
                    Character animatedValue = (Character) animation.getAnimatedValue();
                    move.setText(String.valueOf(animatedValue));
                }
            });
            valueAnimator.setInterpolator(new AccelerateInterpolator());
            valueAnimator.setEvaluator(new CharEvaluator());
            valueAnimator.start();

        });


        ImageView imageView = findViewById(R.id.circle);
        findViewById(R.id.start_anim).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueAnimator valueAnimator = ValueAnimator.ofObject(new FallingBallEvaluator(), new Point(0, 0), new Point(400, 400));
                valueAnimator.setDuration(1000);
                valueAnimator.start();
                valueAnimator.setInterpolator(new CustomLinearInterpolator());
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        Point point = (Point)animation.getAnimatedValue();
                        imageView.layout(point.x,point.y,point.x+imageView.getWidth(),point.y+imageView.getHeight());

                    }
                });
            }
        });
    }

}
