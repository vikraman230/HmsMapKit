package com.example.hmsmaplibrary;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.huawei.hms.maps.HuaweiMap;
import com.huawei.hms.maps.MapView;
import com.huawei.hms.maps.MapsInitializer;
import com.huawei.hms.maps.OnMapReadyCallback;
import com.huawei.hms.maps.util.LogM;

public class MyMapKitSampleActivity extends AppCompatActivity implements OnMapReadyCallback {
    private static final String TAG = "MapViewDemoActivity";
    //HUAWEI map
    private HuaweiMap hMap;

    private MapView mMapView;

    private static final int REQUEST_CODE = 100;
    private static final String MAPVIEW_BUNDLE_KEY = "MapViewBundleKey";
    private static final String[] RUNTIME_PERMISSIONS = {Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.INTERNET};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LogM.d(TAG, "onCreate:hzj");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        Intent intent=getIntent();
        String key=intent.getStringExtra("apikey");


        if (!hasPermissions(this, RUNTIME_PERMISSIONS)) {
            ActivityCompat.requestPermissions(this, RUNTIME_PERMISSIONS, REQUEST_CODE);
        }

        //get mapview instance
        mMapView = findViewById(R.id.mapView);
        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY);
        }

        MapsInitializer.setApiKey(key);
        mMapView.onCreate(mapViewBundle);
        mMapView.getMapAsync(this);
    }

    @Override
    public void onMapReady(HuaweiMap huaweiMap) {
        //get map instance in a callback method
        LogM.d(TAG, "onMapReady: ");
        hMap = huaweiMap;
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogM.d(TAG, "onStart: ");
        mMapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogM.d(TAG, "onStop: ");
        mMapView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogM.d(TAG, "onDestroy: ");
        mMapView.onDestroy();
    }

    @Override
    protected void onPause() {
        mMapView.onPause();
        LogM.d(TAG, "onPause: ");
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogM.d(TAG, "onResume: ");
        mMapView.onResume();
    }

    private static boolean hasPermissions(Context context, String... permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }
}