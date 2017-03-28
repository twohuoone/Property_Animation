package com.jll.zoro.property_animation;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * @Author : Zoro.
 * @Date : 2017/3/28.
 * @Describe :
 */

public class Circle extends View {
    private int mpic_id;
    public Circle(Context context,int pic_id) {
        super(context);
        mpic_id = pic_id;
    }

    public Circle(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Circle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Circle(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
