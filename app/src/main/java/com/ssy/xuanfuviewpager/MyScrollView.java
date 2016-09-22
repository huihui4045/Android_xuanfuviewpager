package com.ssy.xuanfuviewpager;

import android.content.Context;
import android.os.Build;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by gavin on 2016/9/21.
 */
public class MyScrollView extends NestedScrollView {

    private static StopCall stopCall;

    /**
     * ScrollView向上滑动到顶部的距离
     * 控制scrollview的悬浮框
     */
    private int upH;

    /**
     * 防止scrollview嵌套viewpager滑动 冲突
     */
//    private boolean canScroll;
//    private GestureDetector mGestureDetector;
//    View.OnTouchListener mGestureListener;



//    private GestureDetector mGestureDetector;

    public MyScrollView(Context context) {
        super(context);
        if (Integer.parseInt(Build.VERSION.SDK) >= 9) {
            this.setOverScrollMode(View.OVER_SCROLL_NEVER);
        }
//        mGestureDetector = new GestureDetector(new YScrollDetector());
//        canScroll = true;

//        mGestureDetector = new GestureDetector(context, new YScrollDetector());
//        setFadingEdgeLength(0);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (Integer.parseInt(Build.VERSION.SDK) >= 9) {
            this.setOverScrollMode(View.OVER_SCROLL_NEVER);
        }

        //赋值：300很重要，这个值是顶部2上面的高度，也就是本例中图片的高度
        upH = dpTopx(200);//单位是dp

//        mGestureDetector = new GestureDetector(new YScrollDetector());
//        canScroll = true;

//        mGestureDetector = new GestureDetector(context, new YScrollDetector());
//        setFadingEdgeLength(0);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (Integer.parseInt(Build.VERSION.SDK) >= 9) {
            this.setOverScrollMode(View.OVER_SCROLL_NEVER);
        }

//        mGestureDetector = new GestureDetector(new YScrollDetector());
//        canScroll = true;

//        mGestureDetector = new GestureDetector(context, new YScrollDetector());
//        setFadingEdgeLength(0);
    }


    public static void setCallback(StopCall c) {
        stopCall = c;
    }

    /**
     * 关键部分在这里，测量当前ScrollView滑动的距离
     * <p/>
     * 其中t就是，单位是px哦，不是dp
     * <p/>
     * stopCall是一个接口，是为了在Activity中实现设置顶部1/2可不可见
     */

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (t > upH) {//如果滑动距离>本例中图片高度
            stopCall.stopSlide(true);
            //设置顶部1可见，顶部2不可见
        } else {//否则
            stopCall.stopSlide(false);
            //设置顶部1不可见，顶部2可见
        }
    }

    /**
     * F: 将dp转成为px
     */
    private int dpTopx(int dpValue) {
        final float scale = this.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        if(ev.getAction() == MotionEvent.ACTION_UP)
//            canScroll = true;
//        return super.onInterceptTouchEvent(ev) && mGestureDetector.onTouchEvent(ev);
//    }
//
//    class YScrollDetector extends GestureDetector.SimpleOnGestureListener {
//        @Override
//        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//            if(canScroll)
//                if (Math.abs(distanceY) >= Math.abs(distanceX))
//                    canScroll = true;
//                else
//                    canScroll = false;
//            return canScroll;
//        }
//    }



//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        return super.onInterceptTouchEvent(ev)
//                && mGestureDetector.onTouchEvent(ev);
//    }
//
//    // Return false if we're scrolling in the x direction
//    class YScrollDetector extends GestureDetector.SimpleOnGestureListener {
//        @Override
//        public boolean onScroll(MotionEvent e1, MotionEvent e2,
//                                float distanceX, float distanceY) {
//            return (Math.abs(distanceY) > Math.abs(distanceX));
//        }
//    }
}
