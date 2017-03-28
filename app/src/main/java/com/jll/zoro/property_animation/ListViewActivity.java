package com.jll.zoro.property_animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter arrayAdapter;
    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listView = (ListView) findViewById(R.id.listView);
        initList();
        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.slide_in_left);
        LayoutAnimationController controller = new LayoutAnimationController(animation);
        controller.setOrder(LayoutAnimationController.ORDER_REVERSE);
        controller.setDelay(0.5f);
        listView.setLayoutAnimation(controller);
        listView.startLayoutAnimation();
    }

    private void initList() {
        for(int i=0;i<50;i++){
            String a = "Zoro=="+i;
            list.add(a);
        }
    }
}
