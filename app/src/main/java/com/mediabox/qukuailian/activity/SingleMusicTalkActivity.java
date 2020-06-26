package com.mediabox.qukuailian.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.adapter.LvMusicTalkAdapter;
import com.mediabox.qukuailian.utils.MyUtils;
import com.mediabox.qukuailian.utils.T;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/18.
 * 单曲讨论
 */
public class SingleMusicTalkActivity extends BaseActivity {

    @BindView(R.id.lv_music_talk)
    ListView lv_music_talk;

    @OnClick(R.id.tv_xiugai)
    public void xiugai() {
        Intent intent = new Intent(getApplicationContext(), EvaluateActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.tv_eva_number)
    public void eva() {
        Intent intent = new Intent(getApplicationContext(), CommentActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.tv_agree)
    public void agree() {
        T.show(getApplicationContext(), "赞+1", 0);
    }

    @OnClick(R.id.rl_talk)
    public void talk(){
        Intent intent = new Intent(getApplicationContext(), CommentActivity.class);
        startActivity(intent);
    }


    @OnClick(R.id.fl_back)
    public void back() {
        onBackPressed();
    }

    private ArrayList<String> al_test;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_music_talk);
        ButterKnife.bind(this);
        al_test = new ArrayList<>();
        al_test.add("type1");
        al_test.add("type3");
        al_test.add("type1");
        al_test.add("type2");
        al_test.add("type1");
        al_test.add("type2");
        lv_music_talk.setAdapter(new LvMusicTalkAdapter(al_test, getApplicationContext()));
        MyUtils.setListViewHeightBasedOnChildren(lv_music_talk, getApplicationContext(), null);
        lv_music_talk.setFocusable(false);

    }
}
