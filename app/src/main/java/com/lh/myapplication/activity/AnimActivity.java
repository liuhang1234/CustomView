package com.lh.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Keyframe;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lh.myapplication.R;
import com.lh.myapplication.evaluator.CharEvaluator;
import com.lh.myapplication.evaluator.FallingBallEvaluator;
import com.lh.myapplication.interpolator.CustomLinearInterpolator;

public class AnimActivity extends AppCompatActivity {

    LinearLayout ll;
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

        TextView textView = findViewById(R.id.tv_rotate);
        findViewById(R.id.rotate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                PropertyValuesHolder rotation = PropertyValuesHolder.ofFloat("Rotation", 60f, -60f, 0f);
//                PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat("alpha", 0.1f, 1f, 0.1f, 1f);
//                ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(textView, rotation, alpha);
//                objectAnimator.setDuration(1000);
//                objectAnimator.start();

                Keyframe keyframe0 = Keyframe.ofFloat(0f, 0);
                Keyframe keyframe1 = Keyframe.ofFloat(0.1f, -20f);

                Keyframe keyframe2 = Keyframe.ofFloat(0.2f, 20f);
                Keyframe keyframe3 = Keyframe.ofFloat(0.3f, -20f);
                Keyframe keyframe4 = Keyframe.ofFloat(0.4f, 20f);
                Keyframe keyframe5 = Keyframe.ofFloat(0.5f, -20f);
                Keyframe keyframe6 = Keyframe.ofFloat(0.6f, 20f);
                Keyframe keyframe7 = Keyframe.ofFloat(0.7f, -20f);
                Keyframe keyframe8 = Keyframe.ofFloat(0.8f, 20f);
                Keyframe keyframe9 = Keyframe.ofFloat(0.9f, -20f);
                Keyframe keyframe10 = Keyframe.ofFloat(1, 0);
                keyframe10.setInterpolator(new BounceInterpolator());
                PropertyValuesHolder rotation = PropertyValuesHolder.ofKeyframe("rotation",keyframe0,
                        keyframe1, keyframe2, keyframe3,keyframe4,keyframe5,keyframe6,keyframe7,keyframe8,keyframe9,keyframe10);
                ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(textView, rotation);
                objectAnimator.setDuration(1000*3);
                objectAnimator.setRepeatMode(ValueAnimator.RESTART);
                objectAnimator.start();
            }
        });

         ll = findViewById(R.id.ll);

        LayoutTransition layoutTransition = new LayoutTransition();
        ObjectAnimator rotation = ObjectAnimator.ofFloat(null, "rotationY", 0f, 90f, 0f);
        layoutTransition.setAnimator(LayoutTransition.APPEARING,rotation);
        ObjectAnimator rotation1 = ObjectAnimator.ofFloat(null, "rotation", 0f, 90f, 0f);
        layoutTransition.setAnimator(LayoutTransition.DISAPPEARING,rotation1);
        ll.setLayoutTransition(layoutTransition);
        layoutTransition.addTransitionListener(new LayoutTransition.TransitionListener() {
            @Override
            public void startTransition(LayoutTransition transition, ViewGroup container, View view, int transitionType) {

            }

            @Override
            public void endTransition(LayoutTransition transition, ViewGroup container, View view, int transitionType) {

            }
        });



        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addButton();
            }
        });
        findViewById(R.id.remove).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove();
            }
        });
    }
    int i = 0;
    private void addButton(){
        i++;
        Button button = new Button(this);
        button.setText("button"+i);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(layoutParams);
        ll.addView(button);

    }
    private void remove(){
        if (i>0) {
            ll.removeViewAt(0);
        }
        i--;
    }

}
