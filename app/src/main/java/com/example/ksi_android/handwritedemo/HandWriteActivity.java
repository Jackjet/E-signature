package com.example.ksi_android.handwritedemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HandWriteActivity extends AppCompatActivity {

    @Bind(R.id.view)
    LinePathView mPathView;
    @Bind(R.id.clear1)
    Button mClear;
    @Bind(R.id.ll)
    LinearLayout ll;
    @Bind(R.id.save1)
    Button mSave;
    @Bind(R.id.change)
    Button mChangeColor;
    @Bind(R.id.changewidth)
    Button mChangeWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hand_write);
        ButterKnife.bind(this);
        setResult(50);
        //设置保存监听
        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPathView.getTouched()) {
                    mPathView.save(MainActivity.path, true, 10, true, 0.9);
                    setResult(100);
                    finish();
                } else {

                    Toast.makeText(HandWriteActivity.this, "您没有签名~", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPathView.clear();
            }
        });
        //修改背景颜色和笔的颜色
        mChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                mPathView.setBackColor(Color.RED);
                mPathView.setPenColor(Color.WHITE);
                mPathView.clear();
            }
        });
        //修改笔的宽度
        mChangeWidth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                mPathView.setPaintWidth(20);
                mPathView.clear();
            }
        });
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }
}
