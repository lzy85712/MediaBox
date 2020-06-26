package com.mediabox.qukuailian.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.activity.DynamicDetailActivity;
import com.mediabox.qukuailian.activity.SendDynamicActivity;
import com.mediabox.qukuailian.adapter.LvDynamicAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by lizhaoyong on 2018/7/2.
 */
public class DynamicFragment extends Fragment {
    private Unbinder unbinder;

    @BindView(R.id.tv_discover)
    TextView tv_discover;
    @BindView(R.id.iv_discover)
    ImageView iv_discover;
    @BindView(R.id.tv_attention)
    TextView tv_attention;
    @BindView(R.id.iv_attention)
    ImageView iv_attention;
    @BindView(R.id.tv_my_send)
    TextView tv_my_send;
    @BindView(R.id.iv_my_send)
    ImageView iv_my_send;

    @BindView(R.id.lv_dynamic)
    ListView lv_dynamic;
    @BindView(R.id.srl_dynamic)
    SmartRefreshLayout srl_dynamic;

    private ArrayList<String> al_test;


    @OnClick(R.id.tv_discover)
    public void discoverClick() {
        tv_discover.setTextColor(Color.parseColor("#4a4d6f"));
        tv_attention.setTextColor(Color.parseColor("#a1a3b5"));
        tv_my_send.setTextColor(Color.parseColor("#a1a3b5"));
        iv_discover.setVisibility(View.VISIBLE);
        iv_attention.setVisibility(View.INVISIBLE);
        iv_my_send.setVisibility(View.INVISIBLE);
    }

    @OnClick(R.id.tv_attention)
    public void attentionClick() {
        tv_discover.setTextColor(Color.parseColor("#a1a3b5"));
        tv_attention.setTextColor(Color.parseColor("#4a4d6f"));
        tv_my_send.setTextColor(Color.parseColor("#a1a3b5"));
        iv_discover.setVisibility(View.INVISIBLE);
        iv_attention.setVisibility(View.VISIBLE);
        iv_my_send.setVisibility(View.INVISIBLE);
    }

    @OnClick(R.id.tv_my_send)
    public void mysendClick() {
        tv_discover.setTextColor(Color.parseColor("#a1a3b5"));
        tv_attention.setTextColor(Color.parseColor("#a1a3b5"));
        tv_my_send.setTextColor(Color.parseColor("#4a4d6f"));
        iv_discover.setVisibility(View.INVISIBLE);
        iv_attention.setVisibility(View.INVISIBLE);
        iv_my_send.setVisibility(View.VISIBLE);
    }


    // 发动态
    @OnClick({R.id.iv_send, R.id.tv_send})
    public void send() {
        Intent intent = new Intent(getActivity(), SendDynamicActivity.class);
        startActivity(intent);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dynamic, null);
        unbinder = ButterKnife.bind(this, v);
        al_test = new ArrayList<>();
        al_test.add("type1");
        al_test.add("type2");
        al_test.add("type3");
        al_test.add("type4");
        al_test.add("type1");
        lv_dynamic.setAdapter(new LvDynamicAdapter(al_test, getActivity()));

        lv_dynamic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), DynamicDetailActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
