package com.fynnjason.app.viewstubdemo;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mBtnShow, mBtnHide, mBtnRefresh;
    private View mNetWorkError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
    }

    private void initView() {
        mBtnHide = findViewById(R.id.btn_yin_cang);
        mBtnShow = findViewById(R.id.btn_xian_shi);
    }

    private void initListener() {
        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showError();
            }
        });
        mBtnHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideError();
            }
        });

    }

    private void showError() {
        if (mNetWorkError != null) {
            mNetWorkError.setVisibility(View.VISIBLE);
            return;
        }
        ViewStub stub =  findViewById(R.id.vs_network_error);
        mNetWorkError = stub.inflate();
        mBtnRefresh = mNetWorkError.findViewById(R.id.btn_shua_xin);
        mBtnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "刷新", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void hideError() {
        if (mNetWorkError != null) {
            mNetWorkError.setVisibility(View.GONE);
        }
    }
}
