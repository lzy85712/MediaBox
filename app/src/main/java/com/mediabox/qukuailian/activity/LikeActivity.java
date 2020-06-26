package com.mediabox.qukuailian.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.adapter.LvBuyProdAdapter;
import com.mediabox.qukuailian.adapter.LvLikeAdapter;
import com.mediabox.qukuailian.utils.MyUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/12.
 */
public class LikeActivity extends BaseActivity {
    @BindView(R.id.lv_like)
    ListView lv_like;

    @OnClick(R.id.fl_back)
    public void back() {
        onBackPressed();
    }

    private ArrayList<String> al_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like);
        ButterKnife.bind(this);

        al_test = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            al_test.add("");
        }

        lv_like.setAdapter(new LvLikeAdapter(al_test, getApplicationContext()));
        MyUtils.setListViewHeightBasedOnChildren(lv_like, getApplicationContext(), null);

        lv_like.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), FollowActivity.class);
                startActivity(intent);
            }
        });
    }


}
