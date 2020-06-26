package com.mediabox.qukuailian.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.activity.BuyProdActivity;
import com.mediabox.qukuailian.activity.InfluenceActivity;
import com.mediabox.qukuailian.activity.LikeActivity;
import com.mediabox.qukuailian.activity.MainActivity;
import com.mediabox.qukuailian.activity.MyBalanceActivity;
import com.mediabox.qukuailian.activity.NoSignActivity;
import com.mediabox.qukuailian.activity.PubProdActivity;
import com.mediabox.qukuailian.activity.QrCodeActivity;
import com.mediabox.qukuailian.activity.ReportActivity;
import com.mediabox.qukuailian.activity.SellActivity;
import com.mediabox.qukuailian.activity.SettingActivity;
import com.mediabox.qukuailian.utils.T;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionGen;
import kr.co.namee.permissiongen.PermissionSuccess;

/**
 * Created by lizhaoyong on 2018/7/2.
 */
public class MineFragment extends Fragment {
    private Unbinder unbinder;

    @BindView(R.id.tv_username)
    TextView tv_username;
    @BindView(R.id.tv_lv)
    TextView tv_lv;
    @BindView(R.id.tv_balance)
    TextView tv_balance;
    @BindView(R.id.tv_pub_prod)
    TextView tv_pub_prod;
    @BindView(R.id.tv_buy_prod)
    TextView tv_buy_prod;
    @BindView(R.id.tv_no_sign)
    TextView tv_no_sign;
    @BindView(R.id.tv_like)
    TextView tv_like;
    @BindView(R.id.tv_owner)
    TextView tv_owner;

    Intent intent;

    // 扫码返回结果
    private int REQUEST_CODE = 20;

    // 各种点击事件
    @OnClick(R.id.tv_setting)
    public void setting() {
        intent = new Intent(getActivity(), SettingActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.iv_scan)
    public void scan() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            // 没有权限，申请权限。
            // 请求开启相机权限
            PermissionGen.needPermission(MineFragment.this, 105,
                    new String[]{
                            Manifest.permission.CAMERA}
            );
        } else {
            // 有权限了
            intent = new Intent(getActivity(), CaptureActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
        }
    }

    @OnClick(R.id.iv_qrcode)
    public void qrcode() {
        intent = new Intent(getActivity(), QrCodeActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.rl_upt)
    public void upt() {
        intent = new Intent(getActivity(), MyBalanceActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.rl_pub_prod)
    public void pub_prod() {
        intent = new Intent(getActivity(), PubProdActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.rl_buy_prod)
    public void buy_prod() {
        intent = new Intent(getActivity(), BuyProdActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.rl_no_sign)
    public void no_sign() {
        intent = new Intent(getActivity(), NoSignActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.rl_like)
    public void like() {
        intent = new Intent(getActivity(), LikeActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.rl_owner)
    public void owner() {
        intent = new Intent(getActivity(), SellActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.rl_warning)
    public void warning() {
        intent = new Intent(getActivity(), ReportActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.rl_influence)
    public void influence() {
        intent = new Intent(getActivity(), InfluenceActivity.class);
        startActivity(intent);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mine, null);
        unbinder = ButterKnife.bind(this, v);
        // 初始化二维码扫描
        ZXingLibrary.initDisplayOpinion(getActivity());
        return v;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        PermissionGen.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }

    @PermissionSuccess(requestCode = 105)
    public void doSomething() {
        T.show(getActivity(), "相机权限已开启", 0);
    }

    @PermissionFail(requestCode = 105)
    public void doFailSomething() {
        T.show(getActivity(), "相机权限打开失败！", 0);
    }


    // 二维码扫描结果显示
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    T.show(getActivity(), "解析结果:" + result, 0);
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    T.show(getActivity(), "解析二维码失败", 0);
                }
            }
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
