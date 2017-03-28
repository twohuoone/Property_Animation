package com.jll.zoro.property_animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FloatCircleActivity extends AppCompatActivity implements View.OnClickListener{
//    private Button imageView1,imageView2,imageView3,imageView4,imageView5;
    private Button mMenuButton;
    private Button mItemButton1;
    private Button mItemButton2;
    private Button mItemButton3;
    private Button mItemButton4;
    private Button mItemButton5;
    private boolean flag = false;
    private boolean mIsMenuOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_float_circle);
        initView();
//        imageView1 = (Button) findViewById(R.id.item1);
//        imageView2 = (Button) findViewById(R.id.item2);
//        imageView3 = (Button) findViewById(R.id.item3);
//        imageView4 = (Button) findViewById(R.id.item4);
//        imageView5 = (Button) findViewById(R.id.item5);

    }
    private void initView() {
        mMenuButton = (Button) findViewById(R.id.menu);
        mMenuButton.setOnClickListener(this);

        mItemButton1 = (Button) findViewById(R.id.item1);
        mItemButton1.setOnClickListener(this);

        mItemButton2 = (Button) findViewById(R.id.item2);
        mItemButton2.setOnClickListener(this);

        mItemButton3 = (Button) findViewById(R.id.item3);
        mItemButton3.setOnClickListener(this);

        mItemButton4 = (Button) findViewById(R.id.item4);
        mItemButton4.setOnClickListener(this);

        mItemButton5 = (Button) findViewById(R.id.item5);
        mItemButton5.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(500,
//                500);
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT);
//        mMenuButton.setLayoutParams(params);
        if (v == mMenuButton) {
            if (!mIsMenuOpen) {
                mIsMenuOpen = true;
                doAnimateOpen(mItemButton1, 0, 5, 300);
                doAnimateOpen(mItemButton2, 1, 5, 300);
                doAnimateOpen(mItemButton3, 2, 5, 300);
                doAnimateOpen(mItemButton4, 3, 5, 300);
                doAnimateOpen(mItemButton5, 4, 5, 300);
            } else {
                mIsMenuOpen = false;
                doAnimateClose(mItemButton1, 0, 5, 300);
                doAnimateClose(mItemButton2, 1, 5, 300);
                doAnimateClose(mItemButton3, 2, 5, 300);
                doAnimateClose(mItemButton4, 3, 5, 300);
                doAnimateClose(mItemButton5, 4, 5, 300);
            }
        } else {
            Toast.makeText(this, "你点击了" + v, Toast.LENGTH_SHORT).show();
        }
    }
    private void doAnimateClose(final View view, int index, int total,
                                int radius) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
        double degree = Math.PI * index / ((total - 1) * 2);
        int translationX = -(int) (radius * Math.sin(degree));
        int translationY = -(int) (radius * Math.cos(degree));
        AnimatorSet set = new AnimatorSet();
        //包含平移、缩放和透明度动画
        set.playTogether(
                ObjectAnimator.ofFloat(view, "translationX", translationX, 0),
                ObjectAnimator.ofFloat(view, "translationY", translationY, 0),
                ObjectAnimator.ofFloat(view, "scaleX", 1f, 0f),
                ObjectAnimator.ofFloat(view, "scaleY", 1f, 0f),
                ObjectAnimator.ofFloat(view, "alpha", 1f, 0f));

        set.setDuration(1 * 500).start();
    }
    private void doAnimateOpen(View view, int index, int total, int radius) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
        double degree = Math.toRadians(90)/(total - 1) * index;
        int translationX = -(int) (radius * Math.sin(degree));
        int translationY = -(int) (radius * Math.cos(degree));

        AnimatorSet set = new AnimatorSet();
        //包含平移、缩放和透明度动画
        set.playTogether(
                ObjectAnimator.ofFloat(view, "translationX", 0, translationX),
                ObjectAnimator.ofFloat(view, "translationY", 0, translationY),
                ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f),
                ObjectAnimator.ofFloat(view, "scaleY", 0f, 1f),
                ObjectAnimator.ofFloat(view, "alpha", 0f, 1));
        //动画周期为500ms
        set.setDuration(1 * 500).start();
    }

//    private void animation_2() {
//        ValueAnimator animator = ValueAnimator.ofInt(100,520);
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                int result = (int) animation.getAnimatedValue();
//                imageView1.layout(result,result,result+imageView1.getWidth(),result+imageView1.getHeight());
//            }
//        });
//        animator.start();
//    }
//
//    private void animation_1() {
//        ValueAnimator animator = ValueAnimator.ofInt(520,100);
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                int result = (int) animation.getAnimatedValue();
//                imageView1.layout(result,result,result+imageView1.getWidth(),result+imageView1.getHeight());
//            }
//        });
//        animator.start();
//    }
//    private void animation_3() {
//        ValueAnimator animator = ValueAnimator.ofInt(520,150);
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                int result = (int) animation.getAnimatedValue();
//                imageView2.layout(result,result,result+imageView2.getWidth(),result+imageView2.getHeight());
//            }
//        });
//        animator.start();
//    }
//
//    private void animation_4() {
//        ValueAnimator animator = ValueAnimator.ofInt(150,520);
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                int result = (int) animation.getAnimatedValue();
//                imageView2.layout(result,result,result+imageView2.getWidth(),result+imageView2.getHeight());
//            }
//        });
//        animator.start();
//    }
//    private void animation_5() {
//        ValueAnimator animator = ValueAnimator.ofInt(520,200);
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                int result = (int) animation.getAnimatedValue();
//                imageView3.layout(result,result,result+imageView3.getWidth(),result+imageView3.getHeight());
//            }
//        });
//        animator.start();
//    }
//
//    private void animation_6() {
//        ValueAnimator animator = ValueAnimator.ofInt(200,520);
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                int result = (int) animation.getAnimatedValue();
//                imageView3.layout(result,result,result+imageView3.getWidth(),result+imageView3.getHeight());
//            }
//        });
//        animator.start();
//    }
//    private void animation_7() {
//        ValueAnimator animator = ValueAnimator.ofInt(520,250);
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                int result = (int) animation.getAnimatedValue();
//                imageView4.layout(result,result,result+imageView4.getWidth(),result+imageView4.getHeight());
//            }
//        });
//        animator.start();
//    }
//
//    private void animation_8() {
//        ValueAnimator animator = ValueAnimator.ofInt(250,520);
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                int result = (int) animation.getAnimatedValue();
//                imageView4.layout(result,result,result+imageView4.getWidth(),result+imageView4.getHeight());
//            }
//        });
//        animator.start();
//    }
//    private void animation_9() {
//        ValueAnimator animator = ValueAnimator.ofInt(520,300);
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                int result = (int) animation.getAnimatedValue();
//                imageView5.layout(result,result,result+imageView5.getWidth(),result+imageView5.getHeight());
//            }
//        });
//        animator.start();
//    }
//
//    private void animation_10() {
//        ValueAnimator animator = ValueAnimator.ofInt(300,520);
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                int result = (int) animation.getAnimatedValue();
//                imageView5.layout(result,result,result+imageView5.getWidth(),result+imageView5.getHeight());
//            }
//        });
//        animator.start();
//    }
}
