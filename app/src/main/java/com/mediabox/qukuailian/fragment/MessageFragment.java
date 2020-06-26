package com.mediabox.qukuailian.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.activity.EditMessageActivity;
import com.mediabox.qukuailian.adapter.LvMessageAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by lizhaoyong on 2018/7/2.
 */
public class MessageFragment extends Fragment {

    private Unbinder unbinder;
    @BindView(R.id.lv_message)
    ListView lv_messgae;

    @OnClick(R.id.tv_edit)
    public void edit() {
        Intent intent = new Intent(getActivity(), EditMessageActivity.class);
        startActivity(intent);
    }

    private ArrayList<String> al_test;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_message, null);
        unbinder = ButterKnife.bind(this, v);
        al_test = new ArrayList<String>();
        al_test.add("type1");
        al_test.add("type2");
        al_test.add("type3");
        al_test.add("type4");
        al_test.add("type2");
        al_test.add("type1");
        al_test.add("type1");
        al_test.add("type4");
        al_test.add("type3");

        lv_messgae.setAdapter(new LvMessageAdapter(al_test, getActivity(), false, false));


        return v;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
