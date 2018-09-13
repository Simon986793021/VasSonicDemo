package com.poco.vassonicdemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tencent.sonic.sdk.SonicConfig;
import com.tencent.sonic.sdk.SonicEngine;

public class MainActivity extends AppCompatActivity {
    private Button normal;
    private Button vasSonic;
    private final String url ="http://mc.vip.qq.com/demo/indexv3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        if (!SonicEngine.isGetInstanceAllowed()) {
            SonicEngine.createInstance(new SonicRuntimeImpl(getApplication()), new SonicConfig.Builder().build());
        }
    }

    private void initView() {
        normal = findViewById(R.id.bt_normal);
        vasSonic = findViewById(R.id.bt_vassonic);
        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MainActivity.this, true);
            }
        });


        vasSonic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MainActivity.this, false);
            }
        });
    }

    private void startActivity(Context context, boolean isNormal) {
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra(WebViewActivity.ARGS_NORMAL, isNormal);
        intent.putExtra(WebViewActivity.ARGS_URL,url);
        startActivity(intent);
    }
}
