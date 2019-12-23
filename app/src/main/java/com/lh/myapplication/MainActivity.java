package com.lh.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.StateSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView myRecyclerView;
    private MyNestedScrollView myNestScrollView;
    private View view_white;
    private ImageView imageback;
    private TextView tvColorChange;
    private RelativeLayout relatv_change;
    private ImageView topImageview;
    private int height;// 实时变化的高度
    private View viewtiao;
    private Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        initView();
        getHeighOfTopView();
        initRecyclerView();
        mActivity = this;

        myNestScrollView.setmOnScrollViewListenner(new MyNestedScrollView.OnScrollViewListenner() {
            @Override
            public void onScrollChanged(MyNestedScrollView mMyScrollView, int l, int t, int oldl, int oldt) {

                //对T轴进行判断,就俩种状态1.消失没有了    2.随着滑动,颜色越来越深
                if (t <= 0) {//没有往下滑
                    StatusBarUtil.StatusBarDarkMode(MainActivity.this, 3);
                    //设置标题隐藏
//                    view_white.setVisibility(View.GONE);
//                    relatv_change.setVisibility(View.GONE);
                    //设置标题所在背景为透明
                    relatv_change.setBackgroundColor(Color.argb(0, 0, 0, 0));
                    viewtiao.setBackgroundColor(Color.argb(0, 0, 0, 0));
                }
                //大于0表示有位移 正在拖动中,发生颜色变化的同时不超过顶部图片的高度
                else if (t > 0 && t < height) {
                    view_white.setVisibility(View.VISIBLE);
                    StatusBarUtil.StatusBarLightMode(MainActivity.this);
                    //显示标题
                    relatv_change.setVisibility(View.VISIBLE);
                    //获取ScrollView向下滑动,图片消失部分的比例    注意在配置比例时  一定要强转float
                    float scale = (float) t / height;
                    //根据这个比例,让标题的颜色慢慢的由浅入深
                    float alpha = (255 * scale);
                    //设置标题的内容和颜色
                    tvColorChange.setText("我是标题");
                    tvColorChange.setTextColor(Color.argb((int) alpha, 0, 0, 0));
                    //设置标题布局颜色
                    relatv_change.setBackgroundColor(Color.argb((int) alpha, 255, 255, 255));
                    viewtiao.setBackgroundColor(Color.argb((int) alpha, 255, 255, 255));

                    if (scale<0.5) {

                        imageback.setAlpha(1- 2 * scale);
//                        imageback.setImageResource(R.drawable.back);
                        ColorStateList colorStateList = ColorStateList.valueOf(Color.parseColor("#FF0000"));


                        imageback.setImageTintList(colorStateList);
                    } else {
                        imageback.setAlpha(2 * (scale - 0.5f));
                        ColorStateList colorStateList = ColorStateList.valueOf(Color.parseColor("#0000FF"));

//                        imageback.setImageResource(R.drawable.back2);
                        imageback.setImageTintList(colorStateList);

                    }
                } else {

                    tvColorChange.setTextColor(getResources().getColor(R.color.colorPrimary));
                    viewtiao.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                }
            }
        });
    }

    private void initRecyclerView() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            list.add("第" + i + "条数据");
        }
        MyAdapter myAdapter = new MyAdapter(R.layout.item, list);
        CustomLinearLayoutManager linearLayoutManager = new CustomLinearLayoutManager(this);
        linearLayoutManager.setScrollEnabled(false);
        myRecyclerView.setAdapter(myAdapter);
        myRecyclerView.setLayoutManager(linearLayoutManager);
    }

    private void getHeighOfTopView() {
        //获取控件的试图观察者,以便通过试图观察者得到控件的宽高参数
        ViewTreeObserver viewTreeObserver = topImageview.getViewTreeObserver();
        //添加观察者监听
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @Override
            public void onGlobalLayout() {
                //回调监听后首先移除该监听 占资源
                topImageview.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                //得到高度
                height = topImageview.getHeight();
            }
        });

    }

    private void initView() {
        myRecyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);
        myNestScrollView = (MyNestedScrollView) findViewById(R.id.myNestScrollView);
        view_white = (View) findViewById(R.id.view_white);
        imageback = (ImageView) findViewById(R.id.imageback);
        tvColorChange = (TextView) findViewById(R.id.tvColorChange);
        relatv_change = (RelativeLayout) findViewById(R.id.relatv_change);
        topImageview = (ImageView) findViewById(R.id.topImageview);
        imageback.setOnClickListener(this);
        viewtiao = (View) findViewById(R.id.viewtiao);
        viewtiao.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageback:
                Toast.makeText(this, "imageback", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }


}
