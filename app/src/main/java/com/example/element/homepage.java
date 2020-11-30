package com.example.element;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class homepage extends AppCompatActivity implements View.OnClickListener {

    private Button btnWater,btnFire,btnEarth,btnAir;
    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        btnWater = findViewById(R.id.waterbtn);
        btnFire = findViewById(R.id.firebtn);
        btnEarth = findViewById(R.id.earthbtn);
        btnAir = findViewById(R.id.airhbtn);

        btnWater.setOnClickListener(this);
        btnFire.setOnClickListener(this);
        btnEarth.setOnClickListener(this);
        btnAir.setOnClickListener(this);

        models = new ArrayList<>();
        models.add(new Model(R.drawable.underwatercard, "Water", "Change starts with you! plan events, surf events, meet people, Let's save the oceans together!"));
        models.add(new Model(R.drawable.darkboncard, "Fire", "Reach out to your community, donate clothes, gadgets, the goal is  to help others!"));
        models.add(new Model(R.drawable.leopardcard, "Earth", "Find out where you can recycle your waste to help reduce pollution!"));
        models.add(new Model(R.drawable.skycard, "Air", "You ever thought about how much energy and electricity you waste everyday? we'll help you find out!"));

        adapter = new Adapter(models, this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4)
        };

        colors=colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position < (adapter.getCount()-1) && position < (colors.length - 1 ))
                {
                    viewPager.setBackgroundColor(
                            (Integer) argbEvaluator.evaluate(
                                    positionOffset , colors[position] , colors[position+1]));

                }
                else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void onClick(View view) {
        if(view==btnWater)
        {
            Intent intent = new Intent(this,Water.class);
            startActivity(intent);
        }
        else if(view==btnFire)
        {
            Intent intent = new Intent(this,Fire.class);
            startActivity(intent);
        }
        else if(view==btnEarth)
        {
            Intent intent = new Intent(this,Earth.class);
            startActivity(intent);
        }
        else if(view==btnAir)
        {
            Intent intent = new Intent(this,Air.class);
            startActivity(intent);
        }


    }
}