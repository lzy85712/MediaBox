package com.mediabox.qukuailian.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.adapter.LvCountryAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lizhaoyong on 2018/7/3.
 * 选择国籍
 */
public class SelectCountryActivity extends BaseActivity {
    @BindView(R.id.lv_country)
    ListView lv_country;

    private ArrayList<String> al_datas;
    private int[] country_icons = {R.mipmap.china_icon, R.mipmap.hongkong, R.mipmap.japan, R.mipmap.thailand, R.mipmap.usa, R.mipmap.unitedkingdom, R.mipmap.australia, R.mipmap.taiwan};
    private LvCountryAdapter lca;
    private int position = 0;

    // 返回上个页面
    public void back(int position) {
        Intent intent = new Intent();
        intent.putExtra("position", position);
        setResult(2, intent);
        finish();
    }


    @Override
    public void onBackPressed() {
        back(position);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_country);
        ButterKnife.bind(this);
        position = getIntent().getIntExtra("position", 0);

        al_datas = new ArrayList<String>();
        al_datas.add("中国");
        al_datas.add("香港");
        al_datas.add("日本");
        al_datas.add("泰国");
        al_datas.add("美国");
        al_datas.add("英国");
        al_datas.add("澳大利亚");
        al_datas.add("中国台湾");
        lca = new LvCountryAdapter(al_datas, country_icons, getApplicationContext(), position, this);
        lv_country.setAdapter(lca);
    }
}
