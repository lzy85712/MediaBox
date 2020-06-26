package com.mediabox.qukuailian.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.fragment.DynamicFragment;
import com.mediabox.qukuailian.fragment.FriendFragment;
import com.mediabox.qukuailian.fragment.MarketFragment;
import com.mediabox.qukuailian.fragment.MessageFragment;
import com.mediabox.qukuailian.fragment.MineFragment;
import com.mediabox.qukuailian.service.SuspensionService;
import com.mediabox.qukuailian.utils.AppManager;
import com.mediabox.qukuailian.utils.T;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/2.
 */
public class MainActivity extends BaseActivity {

    private long mExitTime;
    private int mIndex;
    public Fragment[] mFragments;

    @BindView(R.id.fl_content)
    FrameLayout fl_content;
    @BindView(R.id.rg_group)
    RadioGroup rg_group;


    // 点击事件
    @OnClick({R.id.rb_market, R.id.rb_friend, R.id.rb_message, R.id.rb_dynamic, R.id.rb_mine})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb_market:
                setIndexSelected(0);
                break;
            case R.id.rb_friend:
                setIndexSelected(1);
                break;
            case R.id.rb_message:
                setIndexSelected(2);
                break;
            case R.id.rb_dynamic:
                setIndexSelected(3);
                break;
            case R.id.rb_mine:
                setIndexSelected(4);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initFragments();
        rg_group.check(R.id.rb_market);


    }

    // 初始化5个页面
    public void initFragments() {
        MarketFragment mf = new MarketFragment();
        FriendFragment ff = new FriendFragment();
        MessageFragment msgf = new MessageFragment();
        DynamicFragment df = new DynamicFragment();
        MineFragment minef = new MineFragment();
        mFragments = new Fragment[]{mf, ff, msgf, df, minef};
        FragmentTransaction ft =
                getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fl_content, mf).commit();
        setIndexSelected(0);
    }

    // 设置显示指定的fragment
    public void setIndexSelected(int index) {
        // 设置状态栏颜色
        if (index == 4) {
            setStatusBarStyle("type3");
        } else {
            setStatusBarStyle("type1");
        }


        if (mIndex == index) {
            return;
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        //隐藏
        ft.hide(mFragments[mIndex]);
        //判断是否添加
        if (!mFragments[index].isAdded()) {
            ft.add(R.id.fl_content, mFragments[index]).show(mFragments[index]);
        } else {
            ft.show(mFragments[index]);
        }
        // 异步防止频繁操作崩溃
        fragmentManager.executePendingTransactions();
        ft.commit();
        //再次赋值
        mIndex = index;
    }

    // APP退出管理
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                if ((System.currentTimeMillis() - mExitTime) > 2000) {
                    T.showShort(getApplicationContext(), "再按一次退出程序");
                    mExitTime = System.currentTimeMillis();
                } else {
                    // 关闭悬浮窗
                    Intent intent = new Intent(getApplicationContext(), SuspensionService.class);
                    stopService(intent);
                    AppManager.getAppManager().AppExit(this);
                    finish();
                }
                break;
            default:
                return super.onKeyDown(keyCode, event);
        }
        return true;
    }
}
