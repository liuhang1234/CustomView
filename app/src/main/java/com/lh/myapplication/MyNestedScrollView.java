package com.lh.myapplication;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;

public class MyNestedScrollView extends NestedScrollView {
    public MyNestedScrollView(@NonNull Context context) {
        super(context);
    }

    public MyNestedScrollView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyNestedScrollView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //自定义接口
    public interface OnScrollViewListenner {
        //把方法放进去  做修改加入本类对象参数
        void onScrollChanged(MyNestedScrollView mMyScrollView, int l, int t, int oldl, int oldt);
    }

    //定义自己的接口变量
    private OnScrollViewListenner mOnScrollViewListenner;

    //设置Set方法
    public void setmOnScrollViewListenner(OnScrollViewListenner mOnScrollViewListenner) {
        this.mOnScrollViewListenner = mOnScrollViewListenner;
    }
    //覆写滑动监听方法 再做一个自己的接口
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mOnScrollViewListenner != null) {
            mOnScrollViewListenner.onScrollChanged(this, l, t, oldl, oldt);
        }
    }


}
