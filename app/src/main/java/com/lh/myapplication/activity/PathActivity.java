package com.lh.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.lh.myapplication.R;

public class PathActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path);
        ImageView imageView = findViewById(R.id.img);
        findViewById(R.id.edit).setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    AnimatedVectorDrawableCompat animatedVectorDrawableCompat = AnimatedVectorDrawableCompat.create(PathActivity.this, R.drawable.search);
                    imageView.setImageDrawable(animatedVectorDrawableCompat);
                    Animatable animatable = (Animatable) (imageView.getDrawable());
                    animatable.start();
                }
            }
        });
    }
}
