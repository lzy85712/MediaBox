package com.mediabox.qukuailian.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.adapter.LvBuyAdapter;
import com.mediabox.qukuailian.adapter.LvDynamicAdapter;
import com.mediabox.qukuailian.adapter.LvFriendAdapter;
import com.mediabox.qukuailian.adapter.LvProdAdapter;
import com.mediabox.qukuailian.adapter.VpPersonalMallAdapter;
import com.mediabox.qukuailian.utils.Fglass;
import com.mediabox.qukuailian.utils.MyUtils;
import com.mediabox.qukuailian.view.ViewPagerForScrollView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/10.
 * 个人商城
 */
public class PersonalMallActivity extends BaseActivity {
    @BindView(R.id.vp_persional_mall)
    ViewPagerForScrollView vp_persional_mall;

    @BindView(R.id.tv_number_indicator_one)
    TextView tv_number_indicator_one;
    @BindView(R.id.tv_indicator_one)
    TextView tv_indicator_one;
    @BindView(R.id.tv_number_indicator_two)
    TextView tv_number_indicator_two;
    @BindView(R.id.tv_indicator_two)
    TextView tv_indicator_two;
    @BindView(R.id.tv_number_indicator_three)
    TextView tv_number_indicator_three;
    @BindView(R.id.tv_indicator_three)
    TextView tv_indicator_three;
    @BindView(R.id.tv_number_indicator_four)
    TextView tv_number_indicator_four;
    @BindView(R.id.tv_indicator_four)
    TextView tv_indicator_four;
    @BindView(R.id.tv_number_indicator_five)
    TextView tv_number_indicator_five;
    @BindView(R.id.tv_indicator_five)
    TextView tv_indicator_five;

    @BindView(R.id.ll_middle_indicator)
    LinearLayout ll_middle_indicator;
    @BindView(R.id.rl_head_bg)
    RelativeLayout rl_head_bg;

    @OnClick(R.id.rl_indicator_one)
    public void indicatorOneClick() {
        vp_persional_mall.setCurrentItem(0);
    }

    @OnClick(R.id.rl_indicator_two)
    public void indicatorTwoClick() {
        vp_persional_mall.setCurrentItem(1);
    }

    @OnClick(R.id.rl_indicator_three)
    public void indicatorThreeClick() {
        vp_persional_mall.setCurrentItem(2);
    }

    @OnClick(R.id.rl_indicator_four)
    public void indicatorFourClick() {
        vp_persional_mall.setCurrentItem(3);
    }

    @OnClick(R.id.rl_indicator_five)
    public void indicatorFiveClick() {
        vp_persional_mall.setCurrentItem(4);
    }

    // 显示不同的样式
    public void showIndicatorCurrentStyle(int position) {
        switch (position) {
            case 0:
                tv_indicator_one.setTextColor(Color.parseColor("#4a4d6f"));
                tv_number_indicator_one.setTextColor(Color.parseColor("#4a4d6f"));

                tv_indicator_two.setTextColor(Color.parseColor("#a1a3b5"));
                tv_number_indicator_two.setTextColor(Color.parseColor("#a1a3b5"));
                tv_indicator_three.setTextColor(Color.parseColor("#a1a3b5"));
                tv_number_indicator_three.setTextColor(Color.parseColor("#a1a3b5"));
                tv_indicator_four.setTextColor(Color.parseColor("#a1a3b5"));
                tv_number_indicator_four.setTextColor(Color.parseColor("#a1a3b5"));
                tv_indicator_five.setTextColor(Color.parseColor("#a1a3b5"));
                tv_number_indicator_five.setTextColor(Color.parseColor("#a1a3b5"));

                break;
            case 1:
                tv_indicator_one.setTextColor(Color.parseColor("#a1a3b5"));
                tv_number_indicator_one.setTextColor(Color.parseColor("#a1a3b5"));

                tv_indicator_two.setTextColor(Color.parseColor("#4a4d6f"));
                tv_number_indicator_two.setTextColor(Color.parseColor("#4a4d6f"));

                tv_indicator_three.setTextColor(Color.parseColor("#a1a3b5"));
                tv_number_indicator_three.setTextColor(Color.parseColor("#a1a3b5"));
                tv_indicator_four.setTextColor(Color.parseColor("#a1a3b5"));
                tv_number_indicator_four.setTextColor(Color.parseColor("#a1a3b5"));
                tv_indicator_five.setTextColor(Color.parseColor("#a1a3b5"));
                tv_number_indicator_five.setTextColor(Color.parseColor("#a1a3b5"));

                break;
            case 2:
                tv_indicator_one.setTextColor(Color.parseColor("#a1a3b5"));
                tv_number_indicator_one.setTextColor(Color.parseColor("#a1a3b5"));
                tv_indicator_two.setTextColor(Color.parseColor("#a1a3b5"));
                tv_number_indicator_two.setTextColor(Color.parseColor("#a1a3b5"));

                tv_indicator_three.setTextColor(Color.parseColor("#4a4d6f"));
                tv_number_indicator_three.setTextColor(Color.parseColor("#4a4d6f"));

                tv_indicator_four.setTextColor(Color.parseColor("#a1a3b5"));
                tv_number_indicator_four.setTextColor(Color.parseColor("#a1a3b5"));
                tv_indicator_five.setTextColor(Color.parseColor("#a1a3b5"));
                tv_number_indicator_five.setTextColor(Color.parseColor("#a1a3b5"));

                break;

            case 3:
                tv_indicator_one.setTextColor(Color.parseColor("#a1a3b5"));
                tv_number_indicator_one.setTextColor(Color.parseColor("#a1a3b5"));
                tv_indicator_two.setTextColor(Color.parseColor("#a1a3b5"));
                tv_number_indicator_two.setTextColor(Color.parseColor("#a1a3b5"));
                tv_indicator_three.setTextColor(Color.parseColor("#a1a3b5"));
                tv_number_indicator_three.setTextColor(Color.parseColor("#a1a3b5"));

                tv_indicator_four.setTextColor(Color.parseColor("#4a4d6f"));
                tv_number_indicator_four.setTextColor(Color.parseColor("#4a4d6f"));

                tv_indicator_five.setTextColor(Color.parseColor("#a1a3b5"));
                tv_number_indicator_five.setTextColor(Color.parseColor("#a1a3b5"));

                break;
            case 4:
                tv_indicator_one.setTextColor(Color.parseColor("#a1a3b5"));
                tv_number_indicator_one.setTextColor(Color.parseColor("#a1a3b5"));
                tv_indicator_two.setTextColor(Color.parseColor("#a1a3b5"));
                tv_number_indicator_two.setTextColor(Color.parseColor("#a1a3b5"));
                tv_indicator_three.setTextColor(Color.parseColor("#a1a3b5"));
                tv_number_indicator_three.setTextColor(Color.parseColor("#a1a3b5"));
                tv_indicator_four.setTextColor(Color.parseColor("#a1a3b5"));
                tv_number_indicator_four.setTextColor(Color.parseColor("#a1a3b5"));

                tv_indicator_five.setTextColor(Color.parseColor("#4a4d6f"));
                tv_number_indicator_five.setTextColor(Color.parseColor("#4a4d6f"));

                break;

        }
    }


    private ArrayList<String> al_test_one;
    private ArrayList<String> al_test_two;
    private ArrayList<String> al_test_friend;
    private ArrayList<String> al_test_dynamic;

    @OnClick(R.id.fl_back)
    public void back() {
        onBackPressed();
    }

    private ArrayList<View> al_views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_mall);
        ButterKnife.bind(this);
        setStatusBarStyle("type3");
        initView();

    }


    public void initView() {
        al_views = new ArrayList<>();
        al_test_one = new ArrayList<>();
        al_test_two = new ArrayList<>();
        al_test_friend = new ArrayList<>();
        al_test_dynamic = new ArrayList<>();

        al_test_one.add("");
        al_test_one.add("type");


        al_test_two.add("type");
        al_test_two.add("");


        View v_one = View.inflate(getApplicationContext(), R.layout.item_vp_mall_one, null);
        View v_two = View.inflate(getApplicationContext(), R.layout.item_vp_mall_two, null);
        View v_three = View.inflate(getApplicationContext(), R.layout.item_vp_mall_three, null);
        View v_four = View.inflate(getApplicationContext(), R.layout.item_vp_mall_four, null);
        View v_five = View.inflate(getApplicationContext(), R.layout.item_vp_mall_five, null);


        ListView slv_one = (ListView) v_one.findViewById(R.id.lv_one);
        ListView slv_two = (ListView) v_one.findViewById(R.id.lv_two);
        slv_one.setFocusable(false);
        slv_two.setFocusable(false);

        slv_one.setAdapter(new LvProdAdapter(al_test_one, getApplicationContext()));
        slv_two.setAdapter(new LvProdAdapter(al_test_two, getApplicationContext()));
        // 设置listview高度
        MyUtils.setListViewHeightBasedOnChildren(slv_one, getApplicationContext(), "");
        MyUtils.setListViewHeightBasedOnChildren(slv_two, getApplicationContext(), "");


        ListView lv_buy = (ListView) v_two.findViewById(R.id.lv_buy);
        lv_buy.setAdapter(new LvBuyAdapter(al_test_one, getApplicationContext()));
        MyUtils.setListViewHeightBasedOnChildren(lv_buy, getApplicationContext(), null);


        ListView lv_friend = (ListView) v_three.findViewById(R.id.lv_friend);
        al_test_friend.add("");
        al_test_friend.add("");
        al_test_friend.add("");
        al_test_friend.add("");
        al_test_friend.add("");
        al_test_friend.add("");
        lv_friend.setAdapter(new LvFriendAdapter(al_test_friend, getApplicationContext()));
        MyUtils.setListViewHeightBasedOnChildren(lv_friend, getApplicationContext(), null);


        ListView lv_dynamic = (ListView) v_four.findViewById(R.id.lv_dynamic);
        al_test_dynamic.add("type1");
        al_test_dynamic.add("type2");
        al_test_dynamic.add("type3");
        al_test_dynamic.add("type4");
        al_test_dynamic.add("type1");
        lv_dynamic.setAdapter(new LvDynamicAdapter(al_test_dynamic, getApplicationContext()));
        MyUtils.setListViewHeightBasedOnChildren(lv_dynamic, getApplicationContext(), null);


        ListView slv_one_history = (ListView) v_five.findViewById(R.id.lv_one);
        ListView slv_two_history = (ListView) v_five.findViewById(R.id.lv_two);

        slv_one_history.setAdapter(new LvProdAdapter(al_test_one, getApplicationContext()));
        slv_two_history.setAdapter(new LvProdAdapter(al_test_two, getApplicationContext()));
        // 设置listview高度
        MyUtils.setListViewHeightBasedOnChildren(slv_one_history, getApplicationContext(), "");
        MyUtils.setListViewHeightBasedOnChildren(slv_two_history, getApplicationContext(), "");

        //ViewPager预加载导致view高度的问题
        vp_persional_mall.setObjectForPosition(v_one, 0);
        vp_persional_mall.setObjectForPosition(v_two, 1);
        vp_persional_mall.setObjectForPosition(v_three, 2);
        vp_persional_mall.setObjectForPosition(v_four, 3);
        vp_persional_mall.setObjectForPosition(v_five, 4);


        al_views.add(v_one);
        al_views.add(v_two);
        al_views.add(v_three);
        al_views.add(v_four);
        al_views.add(v_five);
        vp_persional_mall.setAdapter(new VpPersonalMallAdapter(al_views, getApplicationContext()));


        vp_persional_mall.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // 重新设置高度
                vp_persional_mall.resetHeight(position);
                showIndicatorCurrentStyle(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        // 毛玻璃,效果差
        // Fglass.blur(rl_head_bg, ll_middle_indicator, 2, 32);
        // 设置圆角
        // ll_middle_indicator.setBackgroundDrawable(getResources().getDrawable(R.drawable.corner_view_empty_5radio));
        // fl_back.setBackgroundColor(getResources().getColor(R.color.colorAccent));
    }
}
