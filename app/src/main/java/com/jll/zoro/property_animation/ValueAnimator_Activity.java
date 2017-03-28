package com.jll.zoro.property_animation;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ValueAnimator_Activity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageView;
    private Button move;
    private MyPointView myPointView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator);
        imageView = (ImageView) findViewById(R.id.image);
        move = (Button) findViewById(R.id.move);
        myPointView = (MyPointView) findViewById(R.id.pointview);
        imageView.setOnClickListener(this);
        move.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image:
                Toast.makeText(ValueAnimator_Activity.this, "Click Image", 1).show();
                break;
            case R.id.move:
                doAnimation();
                doAnimation_1();
                myPointView.doPointAnim();
                break;
        }
    }

    private void doAnimation_1() {
        ValueAnimator animator = ValueAnimator.ofObject(new CharEvaluator(), new Character('A'), new Character('Z'));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                char curValue = (char) animation.getAnimatedValue();
                move.setText(String.valueOf(curValue));
            }
        });
        animator.setDuration(3000);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.start();
    }

    private void doAnimation() {
        ValueAnimator animator = ValueAnimator.ofInt(0, 400);
        animator.setDuration(3000);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int) animation.getAnimatedValue();
                imageView.layout(curValue, curValue, curValue + imageView.getWidth(), curValue + imageView.getHeight());
            }
        });
        animator.setInterpolator(new BounceInterpolator());
        animator.start();
    }
}
