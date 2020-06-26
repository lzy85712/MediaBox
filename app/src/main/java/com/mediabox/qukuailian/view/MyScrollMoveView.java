package com.mediabox.qukuailian.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by lizhaoyong on 2018/7/9.
 * 监听滚动状态
 */
public class MyScrollMoveView extends ScrollView {
    private OnScrollListener listener;

    public void setOnScrollListener(OnScrollListener listener) {
        this.listener = listener;
    }

    public MyScrollMoveView(Context context) {
        super(context);
    }

    public MyScrollMoveView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollMoveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //设置接口
    public interface OnScrollListener {
        void onScroll(int scrollY);
    }

    //重写原生onScrollChanged方法，将参数传递给接口，由接口传递出去
    //1. 第一个参数是目前水平滑动后的距离
    //2. 第二个参数是目前垂直滑动后的距离
    //3. 第三个参数是之前水平滑动前的距离
    //4. 第四个参数是之前水平滑动前的距离

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (listener != null) {
            //这里我只传了垂直滑动的距离
            listener.onScroll(t);
        }
    }
}
