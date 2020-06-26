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
import com.mediabox.qukuailian.activity.PersonalMallActivity;
import com.mediabox.qukuailian.adapter.LvFriendAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by lizhaoyong on 2018/7/2.
 */
public class FriendFragment extends Fragment {
    private Unbinder unbinder;

    @BindView(R.id.lv_friend)
    ListView lv_friend;
    @BindView(R.id.tv_title_one)
    TextView tv_title_one;
    @BindView(R.id.tv_title_two)
    TextView tv_title_two;
    @BindView(R.id.tv_title_three)
    TextView tv_title_three;
    @BindView(R.id.iv_indicator_one)
    ImageView iv_indicator_one;
    @BindView(R.id.iv_indicator_two)
    ImageView iv_indicator_two;
    @BindView(R.id.iv_indicator_three)
    ImageView iv_indicator_three;


    private ArrayList<String> al_test;


    @OnClick(R.id.rl_title_one)
    public void titleOneSelected() {
        tv_title_one.setTextColor(Color.parseColor("#4a4d6f"));
        tv_title_two.setTextColor(Color.parseColor("#a1a3b5"));
        tv_title_three.setTextColor(Color.parseColor("#a1a3b5"));
        iv_indicator_one.setVisibility(View.VISIBLE);
        iv_indicator_two.setVisibility(View.INVISIBLE);
        iv_indicator_three.setVisibility(View.INVISIBLE);
    }

    @OnClick(R.id.rl_title_two)
    public void titleTwoSelected() {

        tv_title_one.setTextColor(Color.parseColor("#a1a3b5"));
        tv_title_two.setTextColor(Color.parseColor("#4a4d6f"));
        tv_title_three.setTextColor(Color.parseColor("#a1a3b5"));
        iv_indicator_one.setVisibility(View.INVISIBLE);
        iv_indicator_two.setVisibility(View.VISIBLE);
        iv_indicator_three.setVisibility(View.INVISIBLE);

    }

    @OnClick(R.id.rl_title_three)
    public void titleThreeSelected() {
        tv_title_one.setTextColor(Color.parseColor("#a1a3b5"));
        tv_title_two.setTextColor(Color.parseColor("#a1a3b5"));
        tv_title_three.setTextColor(Color.parseColor("#4a4d6f"));
        iv_indicator_one.setVisibility(View.INVISIBLE);
        iv_indicator_two.setVisibility(View.INVISIBLE);
        iv_indicator_three.setVisibility(View.VISIBLE);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_friend, null);
        unbinder = ButterKnife.bind(this, v);
        al_test = new ArrayList<String>();
        al_test.add("");
        al_test.add("");
        al_test.add("");
        al_test.add("");
        al_test.add("");
        al_test.add("");
        al_test.add("");
        al_test.add("");
        al_test.add("");
        al_test.add("");
        al_test.add("");
        lv_friend.setAdapter(new LvFriendAdapter(al_test, getActivity()));

        lv_friend.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), PersonalMallActivity.class);
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
