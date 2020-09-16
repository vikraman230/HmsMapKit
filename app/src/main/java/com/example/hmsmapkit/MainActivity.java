package com.example.hmsmapkit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hmsmaplibrary.BaseActivity;

public class MainActivity extends BaseActivity {
    private String apiKey="CgB6e3x971tTxn/2P4P1qspdEI3A0vvJFd9J5uI2qgx9E8YY95w25uxIuMQffaJrONZGhlL72WWi3Zy1zlsHbVJN";
    private Button openMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openMap=(Button) findViewById(R.id.btn_open);
        openMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setApiKey(apiKey);
            }
        });

    }
}