package com.lh.myapplication.interpolator;

import android.animation.TimeInterpolator;

public class CustomLinearInterpolator implements TimeInterpolator {
    @Override
    public float getInterpolation(float input) {
        return 1- input;
    }
}
