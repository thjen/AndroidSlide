package com.example.q_thjen.androidslide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import javax.security.auth.Destroyable;

/**
 * Created by q-thjen on 12/16/17.
 */

public class SlideAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SlideAdapter(Context context) {

        this.context = context;
    }

    public int[] slide_color = {

            R.color.color1,
            R.color.color2,
            R.color.color3

    };

    public String[] slideString = {

            "EAT",
            "SLEEP",
            "CODE"

    };

    public String[] slideDescsription = {

            "Hi i am q thjen, I am a software engineer",
            "I am best adc",
            "I live in Phu Ly"

    };

    @Override
    public int getCount() {
        return slideString.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView iv = view.findViewById(R.id.iv1);
        TextView tv1 = view.findViewById(R.id.tv1);
        TextView tv2 = view.findViewById(R.id.tv2);

        iv.setBackgroundColor(slide_color[position]);
        tv1.setText(slideString[position]);
        tv2.setText(slideDescsription[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object );
    }
}
