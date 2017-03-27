package com.jll.zoro.property_animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.image);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"HAHAHAHAH",1).show();
            }
        });
    }

    public void scaleMethold(View view) {
        Animation scale = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scaleanim);
        imageView.startAnimation(scale);
    }

    public void alphaMethold(View view) {
        Animation scale = AnimationUtils.loadAnimation(MainActivity.this, R.anim.alphaanim);
        imageView.startAnimation(scale);
    }

    public void rotateMethold(View view) {
        Animation scale = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotateanim);
        imageView.startAnimation(scale);
    }

    public void setMethold(View view) {
        Animation scale = AnimationUtils.loadAnimation(MainActivity.this, R.anim.one_set);
        imageView.startAnimation(scale);
    }

    public void translateMethold(View view) {
        Animation scale = AnimationUtils.loadAnimation(MainActivity.this, R.anim.translateanim);
        imageView.startAnimation(scale);
    }
}
