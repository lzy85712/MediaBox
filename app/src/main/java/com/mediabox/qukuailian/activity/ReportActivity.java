package com.mediabox.qukuailian.activity;

import android.os.Bundle;
import android.widget.GridView;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.adapter.GvReportAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/12.
 */
public class ReportActivity extends BaseActivity {

    @BindView(R.id.gv_report)
    GridView gv_report;

    @OnClick(R.id.tv_back)
    public void back() {
        onBackPressed();
    }

    private ArrayList<String> al_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        ButterKnife.bind(this);
        al_test = new ArrayList<>();
        al_test.add("");
        al_test.add("");
        al_test.add("");
        gv_report.setAdapter(new GvReportAdapter(al_test, getApplicationContext()));

    }
}
