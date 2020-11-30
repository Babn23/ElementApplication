package com.example.element;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class Adapter2 extends PagerAdapter {

    private List<Design>designs;
    private LayoutInflater layoutInflater;
    private Context context;

    public Adapter2(List<Design> designs, Context context) {
        this.designs = designs;
        this.context = context;
    }

    @Override
    public int getCount() {
        return designs.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.card2 , container , false);

        TextView cause, explanation;

        cause = view.findViewById(R.id.cause);
        explanation = view.findViewById(R.id.explanation);

        cause.setText(designs.get(position).getCause());
        explanation.setText(designs.get(position).getExplanation());

        container.addView(view , 0 );
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
