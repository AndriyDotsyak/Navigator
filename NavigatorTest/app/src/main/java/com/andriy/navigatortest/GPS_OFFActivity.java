package com.andriy.navigatortest;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GPS_OFFActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_Cancel;
    Button btn_Settings;
    private boolean GPSEnabled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps_off);

        btn_Cancel = findViewById(R.id.btn_GPS_OFF_Cancel);
        btn_Settings = findViewById(R.id.btn_GPS_OFF_Settings);

        btn_Cancel.setOnClickListener(this);
        btn_Settings.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        GPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        if (GPSEnabled) {
            this.finish();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_GPS_OFF_Cancel:
                this.finish();
                break;

            case R.id.btn_GPS_OFF_Settings:
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
                break;
        }
    }
}
