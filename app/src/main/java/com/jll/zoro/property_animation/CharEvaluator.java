package com.jll.zoro.property_animation;

import android.animation.TypeEvaluator;

/**
 * @Author : Zoro.
 * @Date : 2017/3/28.
 * @Describe :
 */


public class CharEvaluator implements TypeEvaluator<Character> {
    @Override
    public Character evaluate(float fraction, Character startValue, Character endValue) {
        int startInt  = (int)startValue;
        int endInt = (int)endValue;
        int curInt = (int)(startInt + fraction *(endInt - startInt));
        char result = (char)curInt;
        return result;
    }
}
