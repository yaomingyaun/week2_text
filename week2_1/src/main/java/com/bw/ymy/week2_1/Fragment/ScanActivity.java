package com.bw.ymy.week2_1.Fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.bw.ymy.week2_1.R;

import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;

public class ScanActivity extends AppCompatActivity implements QRCodeView.Delegate{
    private ZXingView mzXingView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        mzXingView=findViewById(R.id.mzXingView);

        mzXingView.setDelegate(this);
    }
    //开启相机
    @Override
    protected void onResume() {
        super.onResume();
        mzXingView.startCamera();
        mzXingView.startSpotAndShowRect();


    }

    @Override
    protected void onStop() {
        super.onStop();
        mzXingView.stopCamera();
    }

    //销毁
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mzXingView.onDestroy();
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        Log.i("dj", "result is " + result);
        Toast.makeText(this,result+"",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onCameraAmbientBrightnessChanged(boolean isDark) {

    }

    @Override
    public void onScanQRCodeOpenCameraError() {

    }
}
