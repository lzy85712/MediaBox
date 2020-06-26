package com.mediabox.qukuailian.activity;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.adapter.GvRecommendAdapter;
import com.mediabox.qukuailian.adapter.GvSearchResultAdapter;
import com.mediabox.qukuailian.utils.Fglass;
import com.mediabox.qukuailian.utils.MyUtils;
import com.mediabox.qukuailian.utils.T;
import com.mediabox.qukuailian.view.MyScrollMoveView;
import com.nex3z.flowlayout.FlowLayout;

import org.w3c.dom.Text;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/9.
 */
public class SearchActivity extends BaseActivity {

    @BindView(R.id.et_search)
    EditText et_search;
    @BindView(R.id.iv_search)
    ImageView iv_search;
    @BindView(R.id.gv_search_result)
    GridView gv_search_result;
    @BindView(R.id.sv_search)
    MyScrollMoveView sv_search;
    @BindView(R.id.tv_search_result)
    TextView tv_search_result;
    @BindView(R.id.rl_recommend)
    RelativeLayout rl_recommend;
    @BindView(R.id.rl_title_bg)
    RelativeLayout rl_title_bg;
    @BindView(R.id.flow_default)
    FlowLayout flow_default;
    @BindView(R.id.flow_category)
    FlowLayout flow_category;
    @BindView(R.id.flow_type)
    FlowLayout flow_type;
    @BindView(R.id.flow_singer)
    FlowLayout flow_singer;

    private ArrayList<String> al_test;
    private ArrayList<String> al_test_recommend;
    private ArrayList<String> al_test_category;
    private ArrayList<String> al_test_type;
    private ArrayList<String> al_test_singer;

    private long afterTime;


    @OnClick(R.id.tv_cancel)
    public void back() {
        onBackPressed();
    }


    public void initTestRecommendData() {
        al_test_recommend = new ArrayList<>();
        al_test_category = new ArrayList<>();
        al_test_type = new ArrayList<>();
        al_test_singer = new ArrayList<>();

        al_test_recommend.add("新歌速递");
        al_test_recommend.add("今日热门");
        al_test_recommend.add("本周热门");
        al_test_recommend.add("本月热门");
        al_test_category.add("流行");
        al_test_category.add("民谣");
        al_test_category.add("电子");
        al_test_category.add("轻音乐");
        al_test_category.add("ACG");
        al_test_category.add("怀旧");
        al_test_category.add("治愈");
        al_test_type.add("音乐");
        al_test_type.add("视频");
        al_test_singer.add("女歌手");
        al_test_singer.add("男歌手");
        al_test_singer.add("华语");
        al_test_singer.add("欧美");
        al_test_singer.add("日韩");


        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        for (int i = 0; i < al_test_recommend.size(); i++) {
            final int position = i;
            View v = inflater.inflate(R.layout.item_gv_recommend, null);
            TextView tv = (TextView) v.findViewById(R.id.tv_name);
            tv.setText(al_test_recommend.get(i));
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    T.show(getApplicationContext(), al_test_recommend.get(position), 0);
                }
            });
            flow_default.addView(v);
        }

        for (int i = 0; i < al_test_category.size(); i++) {
            final int position = i;
            View v = inflater.inflate(R.layout.item_gv_recommend, null);
            TextView tv = (TextView) v.findViewById(R.id.tv_name);
            tv.setText(al_test_category.get(i));
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    T.show(getApplicationContext(), al_test_category.get(position), 0);
                }
            });
            flow_category.addView(v);
        }

        for (int i = 0; i < al_test_type.size(); i++) {
            final int position = i;
            View v = inflater.inflate(R.layout.item_gv_recommend, null);
            TextView tv = (TextView) v.findViewById(R.id.tv_name);
            tv.setText(al_test_type.get(i));
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    T.show(getApplicationContext(), al_test_type.get(position), 0);
                }
            });
            flow_type.addView(v);
        }

        for (int i = 0; i < al_test_singer.size(); i++) {
            final int position = i;
            View v = inflater.inflate(R.layout.item_gv_recommend, null);
            TextView tv = (TextView) v.findViewById(R.id.tv_name);
            tv.setText(al_test_singer.get(i));
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    T.show(getApplicationContext(), al_test_singer.get(position), 0);
                }
            });
            flow_singer.addView(v);
        }
    }


    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        al_test = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            al_test.add("");
        }


        initTestRecommendData();

        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence == null || charSequence.equals("") || charSequence.length() == 0) {
                    iv_search.setImageResource(R.mipmap.search_icon);
                    rl_recommend.setVisibility(View.VISIBLE);
                    sv_search.setVisibility(View.GONE);
                } else {
                    iv_search.setImageResource(R.mipmap.clean);
                    rl_recommend.setVisibility(View.GONE);
                    sv_search.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        // 搜索结果
        gv_search_result.setAdapter(new GvSearchResultAdapter(al_test, getApplicationContext()));
        gv_search_result.setFocusable(false);


        // 滚动监听处理
        sv_search.setOnScrollListener(new MyScrollMoveView.OnScrollListener() {
            @Override
            public void onScroll(int scrollY) {
                int i = MyUtils.dip2px(getApplicationContext(), scrollY);
                int dp = MyUtils.px2dip(getApplicationContext(), i);
                if (dp > 120) {
                    tv_search_result.setVisibility(View.INVISIBLE);
                    long currentTime = System.currentTimeMillis();
                    rl_title_bg.setBackgroundColor(Color.parseColor("#F2C2C3C3"));
//                    if (currentTime - afterTime > 100) {
//                        // 毛玻璃,会很卡OOM
//                        Fglass.blur(sv_search, rl_title_bg, 16, 8);
//                        afterTime = System.currentTimeMillis();
//                    }
                } else {

                    rl_title_bg.setBackgroundColor(getResources().getColor(R.color.login_bg));
                    tv_search_result.setVisibility(View.VISIBLE);
                    tv_search_result.setText("搜索结果（15）");
                }
            }
        });

    }

    // 点击外部软键盘隐藏
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (MyUtils.isShouldHideInput(v, ev)) {
                if (MyUtils.hideInputMethod(this, v)) {
                    return true;
                }
            }
        }
        return super.dispatchTouchEvent(ev);
    }
}
