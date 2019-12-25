package com.lh.myapplication.evaluator;

import android.animation.TypeEvaluator;

// 字符A-Z
public class CharEvaluator implements TypeEvaluator<Character> {
    @Override
    public Character evaluate(float fraction, Character startValue, Character endValue) {
        int satrtInt = (int)startValue;
        int endInt = (int)endValue;
        int current = (int)(satrtInt+fraction*(endInt-satrtInt));
        char result = (char) current;
        return result;
    }
}
