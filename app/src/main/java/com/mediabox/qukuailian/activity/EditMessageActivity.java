package com.mediabox.qukuailian.activity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.adapter.LvMessageAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/21.
 */
public class EditMessageActivity extends BaseActivity {

    @BindView(R.id.lv_message)
    ListView lv_message;
    @BindView(R.id.cb_check_all)
    CheckBox cb_check_all;


    @OnClick(R.id.tv_back)
    public void back() {
        onBackPressed();
    }

    @OnClick(R.id.tv_check_all)
    public void all() {
        if (cb_check_all.isChecked()) {
            cb_check_all.setChecked(false);
        } else {
            cb_check_all.setChecked(true);
        }
    }

    @OnClick(R.id.tv_delete)
    public void delete() {

    }


    private ArrayList<String> al_test;
    private LvMessageAdapter lma;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_message);
        ButterKnife.bind(this);

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
        lma = new LvMessageAdapter(al_test, getApplicationContext(), true, false);
        lv_message.setAdapter(lma);


        cb_check_all.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    lma = new LvMessageAdapter(al_test, getApplicationContext(), true, true);
                } else {
                    lma = new LvMessageAdapter(al_test, getApplicationContext(), true, false);
                }
                lv_message.setAdapter(lma);
            }
        });
    }
}
