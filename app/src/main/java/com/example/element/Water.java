package com.example.element;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButtonToggleGroup;

public class Water extends AppCompatActivity implements View.OnClickListener {

    private Button Surfbtn;
    private ImageView titus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);

        Surfbtn = findViewById(R.id.surfbtn);
        Surfbtn.setOnClickListener(this);

        titus = findViewById(R.id.turtle);
        titus.setOnClickListener(this);


            }

    @Override
    public void onClick(View view) {
        if(view==Surfbtn)
        {
            Intent intent = new Intent(this,PlanningEvent.class);
            startActivity(intent);
        }
        if (view==titus)
        {
            Intent intent = new Intent(this,Causes_for_pol.class);
            startActivity(intent);
        }
    }
}

