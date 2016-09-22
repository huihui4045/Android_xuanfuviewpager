package com.ssy.xuanfuviewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private MyScrollView sv;

    private RelativeLayout invis, invis2;

    private LinearLayout ll;

    private ImageView ivDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = (LinearLayout) findViewById(R.id.ll);
//        DisplayMetrics dm = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
//        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) ll.getLayoutParams();
//        params.width = dm.widthPixels;
//        params.height = dm.heightPixels;
//        ll.setLayoutParams(params);
                /**
                 * 第一个悬浮布局
                 */
        invis = (RelativeLayout) findViewById(R.id.invis);
        invis2 = (RelativeLayout) findViewById(R.id.invis2);
        ivDisplay = (ImageView) findViewById(R.id.main_iv_display);

        sv = (MyScrollView) findViewById(R.id.nestedScrollView);
        sv.setCallback(new StopCall() {
            @Override
            public void stopSlide(boolean isStop) {
                if (isStop) {
                    invis.setVisibility(View.VISIBLE);
                    invis2.setVisibility(View.GONE);
                } else {
                    invis2.setVisibility(View.VISIBLE);
                    invis.setVisibility(View.GONE);
                }
            }
        });




        final MViewPager mPager = (MViewPager) findViewById(R.id.viewPager);
        ResumeAdapter mPagerAdapter = new ResumeAdapter(mPager,getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        final ViewTreeObserver vto = sv.getViewTreeObserver();
        vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                final ViewTreeObserver vto = sv.getViewTreeObserver();
                vto.removeOnPreDrawListener(this);
                int groupSize = sv.getMeasuredHeight() - invis2.getMeasuredHeight();
                int imgHieght= ivDisplay.getMeasuredHeight();
                mPager.setGroupSize(groupSize);
                mPager.setImgHeight(imgHieght);

                return true;
            }
        });


        // ViewPager切换时NestedScrollView滑动到顶部
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                findViewById(R.id.nestedScrollView).scrollTo(0, 0);
                mPager.invalidate();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
