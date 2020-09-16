package com.example.hmsmaplibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);


    }

    public void setApiKey(String apikey) {
        Intent intent = new Intent(getApplicationContext(), MyMapKitSampleActivity.class);
        intent.putExtra("apikey", apikey);
        startActivity(intent);
    }
}