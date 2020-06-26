package com.mediabox.qukuailian.activity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.apkfuns.logutils.LogUtils;
import com.daimajia.numberprogressbar.NumberProgressBar;
import com.daimajia.numberprogressbar.OnProgressBarListener;
import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.utils.T;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/16.
 * 备份
 */
public class BackupsActivity extends BaseActivity implements OnProgressBarListener {

    @BindView(R.id.iv_loading)
    ImageView iv_loading;

    @BindView(R.id.progress_bar)
    NumberProgressBar progressBar;

    @OnClick(R.id.fl_back)
    public void back() {
        onBackPressed();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (timer != null) {
            timer.cancel();
        }
    }

    @OnClick(R.id.tv_start)
    public void start() {
        if (is_start) {
            return;
        }
        is_start = true;
        progressBar.setProgress(0);
        progressBar.setVisibility(View.VISIBLE);
        iv_loading.setVisibility(View.VISIBLE);
        if (circle_anim != null) {
            iv_loading.startAnimation(circle_anim);  //开始动画
        }

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.incrementProgressBy(1);
                    }
                });
            }
        }, 1000, 100);

    }

    private Timer timer;
    private boolean is_start = false;
    // 动画
    private Animation circle_anim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backups);
        ButterKnife.bind(this);
        progressBar.setOnProgressBarListener(this);
        initAnim();

    }

    private void initAnim() {
        circle_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_round_rotate);
        LinearInterpolator interpolator = new LinearInterpolator();  //设置匀速旋转，在xml文件中设置会出现卡顿
        circle_anim.setInterpolator(interpolator);
    }


    @Override
    public void onProgressChange(int current, int max) {
        if (current == max) {
            iv_loading.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.INVISIBLE);
            timer.cancel();
            T.show(getApplicationContext(), getString(R.string.backupsfinish), 0);
            // progressBar.setProgress(0);
            is_start = false;
            iv_loading.clearAnimation();
        }
    }
}
