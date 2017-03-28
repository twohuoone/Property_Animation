package com.jll.zoro.property_animation.DianZan;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jll.zoro.property_animation.R;


/**
 * Created by Zoro on 2017/1/4.
 */

public class FavorLayoutActivity extends Activity {
    private FavorLayout favorLayout;
    private Button aixin;
    private static final String NAME = "jll";
    private static String NAME_1 = "jll";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorlayout);
        favorLayout = (FavorLayout) findViewById(R.id.favor);
        aixin = (Button) findViewById(R.id.aixin);
        aixin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                favorLayout.addFavorWithoutBiz();
            }
        });
    }
}
