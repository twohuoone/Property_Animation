package com.jll.zoro.property_animation;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import static android.R.attr.button;
import static android.R.attr.switchMinWidth;

public class ValueAnimator_Activity extends AppCompatActivity implements View.OnClickListener{
    private ImageView imageView;
    private Button move;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator);
        imageView = (ImageView) findViewById(R.id.image);
        move = (Button) findViewById(R.id.move);
        imageView.setOnClickListener(this);
        move.setOnClickListener(this);
        ValueAnimator animator = ValueAnimator.ofInt(0,400);
        animator.setDuration(1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int)animation.getAnimatedValue();
                Log.d("qijian","curValue:"+curValue);
            }
        });
        animator.start();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.image:
                Toast.makeText(ValueAnimator_Activity.this,"Click Image",1).show();
                break;
            case R.id.move:
                doAnimation();
                break;
        }
    }

    private void doAnimation(){
        ValueAnimator animator = ValueAnimator.ofInt(0,100,50,200,100,300,150,400,200,500);
        animator.setDuration(3000);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int)animation.getAnimatedValue();
                imageView.layout(curValue,curValue,curValue+imageView.getWidth(),curValue+imageView.getHeight());
            }
        });
        animator.start();
    }
}
