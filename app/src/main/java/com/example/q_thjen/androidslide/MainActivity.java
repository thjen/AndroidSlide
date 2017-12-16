package com.example.q_thjen.androidslide;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mLinearLayout;

    private TextView[] mDots;

    Button bt_prev;
    Button bt_next;

    private int mCurrentPage;

    private SlideAdapter mSlideAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLinearLayout = findViewById(R.id.linear1);
        mSlideViewPager = findViewById(R.id.viewpaper);
        bt_next = findViewById(R.id.bt_next);
        bt_prev = findViewById(R.id.bt_prev);

        mSlideAdapter = new SlideAdapter(this);
        mSlideViewPager.setAdapter(mSlideAdapter);

        addDotsIndicator(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);

        // onclick

        bt_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrentPage - 1);
            }
        });

        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrentPage + 1);

                if ( mSlideViewPager.getCurrentItem() == mDots.length - 1) {

                    startActivity(new Intent(MainActivity.this, ActivitySecond.class));
                }

            }
        });

    }

    private void addDotsIndicator(int position) {

        mDots = new TextView[3];
        mLinearLayout.removeAllViews();

        for (int i = 0; i < mDots.length; i++){

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.transparentWhite));

            mLinearLayout.addView(mDots[i]);
        }

        if (mDots.length > 0) {

            mDots[position].setTextColor(getResources().getColor(R.color.white));
        }

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);

            mCurrentPage = position;

            if (position == 0) {

                bt_next.setEnabled(true);
                bt_prev.setEnabled(false);
                bt_prev.setVisibility(View.INVISIBLE);
                bt_next.setVisibility(View.VISIBLE);

                bt_next.setText("Next");
                bt_prev.setText("");

            } else if ( position == mDots.length -1 ) {

                bt_next.setEnabled(true);
                bt_prev.setEnabled(true);
                bt_prev.setVisibility(View.VISIBLE);
                bt_next.setVisibility(View.VISIBLE);

                bt_next.setText("Finish");
                bt_prev.setText("Prev");

            } else {

                bt_next.setEnabled(true);
                bt_prev.setEnabled(true);
                bt_prev.setVisibility(View.VISIBLE);
                bt_next.setVisibility(View.VISIBLE);

                bt_next.setText("Finish");
                bt_prev.setText("Prev");

            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }

    };

}
