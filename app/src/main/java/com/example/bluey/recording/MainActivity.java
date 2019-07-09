package com.example.bluey.recording;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends Activity  {

    private FragmentManager manager;
    //碎片执行者对象
    private FragmentTransaction ft;
    //两个Button点击事件初始化
    private RadioGroup rg;
    private RadioButton btn_luyin;
    private RadioButton btn_jilu;
    private JiluFragment jilu;
    private LuyinFragment luyin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        rg = (RadioGroup) findViewById(R.id.rg);
        btn_luyin = (RadioButton) findViewById(R.id.btn_luyin);
        btn_jilu = (RadioButton) findViewById(R.id.btn_jilu);
        //碎片管理者对象
        manager = getFragmentManager();
        //碎片执行者对象
        ft = manager.beginTransaction();
        luyin = new LuyinFragment();
        jilu = new JiluFragment();
        btn_luyin.setEnabled(false);
        //第一页显示
        if (!luyin.isAdded()) {
            getFragmentManager().beginTransaction().replace(R.id.fl,luyin).commit();
            Log.i("sss","sss");
        }
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                ft = manager.beginTransaction();
                Log.i("sss","sss");
                switch (i) {
                    //第一个按钮 切换
                    case R.id.btn_luyin:
                        //这里要写成替换
                        btn_luyin.setEnabled(false);
                        btn_jilu.setEnabled(true);

                        break;
                    //第二个按钮 切换
                    case R.id.btn_jilu:
                        btn_luyin.setEnabled(true);
                        btn_jilu.setEnabled(false);

                        break;
                }
                //必须要写 不写会造成 白板 没有东西

            }
        });


    }
}
