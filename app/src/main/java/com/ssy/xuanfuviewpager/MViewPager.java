package com.ssy.xuanfuviewpager;

import android.content.Context;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

/**
 * @author wk
 * @Description 解决viewpager 设置wrap_content无效的方法
 * @date 2016年6月22日
 */
public class MViewPager extends ViewPager {

    private List<View> views;

    /**
     * sv的高度 - tab栏的高度
     */
    private int groupSize = 0;

    /**
     * imageView的高度
     */
    private int imgHeight; // 只有第一张有

    /**
     * Constructor
     *
     * @param context the context
     */
    public MViewPager(Context context) {
        super(context);
    }

    /**
     * Constructor
     *
     * @param context the context
     * @param attrs   the attribute set
     */
    public MViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height = 0;
        if (getCurrentItem() > -1 && getCurrentItem() < getAdapter().getCount()) {
           android.support.v4.app.Fragment fragament = (android.support.v4.app.Fragment) ((FragmentPagerAdapter) getAdapter()).instantiateItem(this,getCurrentItem());
            if(fragament !=null){
            View child = fragament.getView();
            if(child != null){
                child.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
                int h = child.getMeasuredHeight();
                if (h > height) {
                    height = h;
                }
                if (getCurrentItem() == 0) {
                    if (height < groupSize - imgHeight) {
                        height = groupSize - imgHeight;
                    }

                } else {
                    if (height < groupSize) {
                        height = groupSize;
                    }
                }
            }
//			 = views.get(getCurrentItem());
            }

        }
        if(height ==0){
            height = groupSize;
        }



        // for (int i = 0; i < getChildCount(); i++) {
        // View child = getChildAt(i);
        // child.measure(widthMeasureSpec,
        // MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
        // int h = child.getMeasuredHeight();
        // if (h > height)
        // height = h;
        // }

        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public int getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(int groupSize) {
        this.groupSize = groupSize;
    }

    public List<View> getViews() {
        return views;
    }

    public void setViews(List<View> views) {
        this.views = views;
    }

    public int getImgHeight() {
        return imgHeight;
    }

    public void setImgHeight(int imgHeight) {
        this.imgHeight = imgHeight;
    }
}
