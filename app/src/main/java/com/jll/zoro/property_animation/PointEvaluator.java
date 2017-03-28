package com.jll.zoro.property_animation;

import android.animation.TypeEvaluator;

/**
 * @Author : Zoro.
 * @Date : 2017/3/28.
 * @Describe :
 */

public class PointEvaluator implements TypeEvaluator<Point> {
    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        int start = startValue.getRadio();
        int end = endValue.getRadio();
        int value = (int) (start + fraction*(end-start));
        return new Point(value);
    }
}
