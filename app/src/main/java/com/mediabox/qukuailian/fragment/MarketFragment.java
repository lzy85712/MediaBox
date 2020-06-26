package com.mediabox.qukuailian.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;
import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.activity.BlessingActivity;
import com.mediabox.qukuailian.activity.CommentActivity;
import com.mediabox.qukuailian.activity.EvaluateActivity;
import com.mediabox.qukuailian.activity.MusicPlayActivity;
import com.mediabox.qukuailian.activity.OriginalSignActivity;
import com.mediabox.qukuailian.activity.PayActivity;
import com.mediabox.qukuailian.activity.RegAndLoginActivity;
import com.mediabox.qukuailian.activity.SearchActivity;
import com.mediabox.qukuailian.activity.SellSignActivity;
import com.mediabox.qukuailian.activity.SendFriendActivity;
import com.mediabox.qukuailian.activity.SignLeaveMsgActivity;
import com.mediabox.qukuailian.activity.SingleMusicBuyActivity;
import com.mediabox.qukuailian.activity.SingleMusicTalkActivity;
import com.mediabox.qukuailian.adapter.LvFriendAdapter;
import com.mediabox.qukuailian.adapter.LvProdAdapter;
import com.mediabox.qukuailian.adapter.MarketVpAdapter;
import com.mediabox.qukuailian.service.SuspensionService;
import com.mediabox.qukuailian.utils.MyUtils;
import com.mediabox.qukuailian.view.ScrollListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lizhaoyong on 2018/7/2.
 */
public class MarketFragment extends Fragment {


    @BindView(R.id.market_vp)
    ViewPager market_vp;

    ArrayList<View> al_views;

    private Unbinder unbinder;


    private ArrayList<String> al_test_one;
    private ArrayList<String> al_test_two;
    private ArrayList<String> al_test_author;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_market, null);

        unbinder = ButterKnife.bind(this, v);

        al_views = new ArrayList<>();

        al_views.add(initProdView());
        al_views.add(initAuthorView());

        market_vp.setAdapter(new MarketVpAdapter(al_views, getActivity()));

        return v;

    }

    public View initProdView() {
        View v_market_prod = View
                .inflate(getActivity(), R.layout.item_vp_market_prod, null);
        ListView slv_one = (ListView) v_market_prod.findViewById(R.id.lv_one);
        ListView slv_two = (ListView) v_market_prod.findViewById(R.id.lv_two);
        // 去搜索页面
        RelativeLayout rl_search = (RelativeLayout) v_market_prod.findViewById(R.id.rl_search);
        rl_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });

        al_test_one = new ArrayList<>();
        al_test_two = new ArrayList<>();

        al_test_one.add("type1");
        al_test_one.add("type2");
        al_test_one.add("type1");
        al_test_one.add("type1");
        al_test_one.add("type2");
        al_test_one.add("type1");

        al_test_two.add("type2");
        al_test_two.add("type1");
        al_test_two.add("type2");
        al_test_two.add("type1");
        al_test_two.add("type1");

        slv_one.setAdapter(new LvProdAdapter(al_test_one, getActivity()));
        slv_two.setAdapter(new LvProdAdapter(al_test_two, getActivity()));
        // 设置listview高度
        MyUtils.setListViewHeightBasedOnChildren(slv_one, getActivity(), "");
        MyUtils.setListViewHeightBasedOnChildren(slv_two, getActivity(), "");


        // 点击事件
        slv_one.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 转发签发
                //Intent intent = new Intent(getActivity(), SellSignActivity.class);
                // 送朋友
                // Intent intent = new Intent(getActivity(), SendFriendActivity.class);
                // 评价页面
                // Intent intent = new Intent(getActivity(), EvaluateActivity.class);
                // 评论页面
                //Intent intent = new Intent(getActivity(), CommentActivity.class);
                // 祝福页面
                // Intent intent = new Intent(getActivity(), BlessingActivity.class);
                // 单曲讨论页面
                // Intent intent = new Intent(getActivity(), SingleMusicTalkActivity.class);
                // 原发签发
                // Intent intent = new Intent(getActivity(), OriginalSignActivity.class);
                // 签发祝福
                // Intent intent = new Intent(getActivity(), SignLeaveMsgActivity.class);
                // 支付页面
                // Intent intent = new Intent(getActivity(), PayActivity.class);
                // 单曲购买页面
                // Intent intent = new Intent(getActivity(), SingleMusicBuyActivity.class);
                // 音乐播放页面
                Intent intent = new Intent(getActivity(), MusicPlayActivity.class);
                // 关闭悬浮窗
                getActivity().stopService(new Intent(getActivity(), SuspensionService.class));
                startActivity(intent);


            }
        });

        // 登录和注册的测试入口
        slv_two.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), RegAndLoginActivity.class);
                startActivity(intent);
            }
        });


        return v_market_prod;
    }

    public View initAuthorView() {
        View v_market_author = View
                .inflate(getActivity(), R.layout.item_vp_market_author, null);
        ListView lv_author = (ListView) v_market_author.findViewById(R.id.lv_author);
        // 去搜索页面
        ImageView iv_search = (ImageView) v_market_author.findViewById(R.id.iv_search);
        iv_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });


        al_test_author = new ArrayList<>();
        al_test_author.add("");
        al_test_author.add("");
        al_test_author.add("");
        al_test_author.add("");
        al_test_author.add("");
        al_test_author.add("");
        al_test_author.add("");
        al_test_author.add("");
        al_test_author.add("");
        al_test_author.add("");
        al_test_author.add("");
        al_test_author.add("");
        lv_author.setAdapter(new LvFriendAdapter(al_test_author, getActivity()));

        return v_market_author;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
