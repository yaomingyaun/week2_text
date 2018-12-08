package com.bw.ymy.week2_1.Fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bw.ymy.week2_1.Activity.LoginActivity;
import com.bw.ymy.week2_1.R;

import java.lang.ref.WeakReference;

import cn.bingoogolapple.qrcode.zxing.QRCodeEncoder;

public class two extends Fragment {

    private ImageView image;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Button kai;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.two, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //获取资源id
        image = view.findViewById(R.id.image);
        kai=view.findViewById(R.id.kai);
        sharedPreferences = getActivity().getSharedPreferences("User", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        //点击开启二维码
        kai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkkkk();
            }
        });


        inlodata();
    }

    //点击 开启扫描二维码
    private  void  checkkkk(){
        //第一步，判断系统版本是否为6.0以上
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){

            if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA},100);
            }else{
                startActivity(new Intent(getActivity(), ScanActivity.class));
            }
        }
    }

    //判断
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==100&&grantResults[0]==PackageManager.PERMISSION_GRANTED)
        {
            startActivity(new Intent(getActivity(),ScanActivity.class));
        }


    }
    //生成二维码

    public void inlodata() {
        String cc = ((LoginActivity) getActivity()).cc();
        QRTask qrTask = new QRTask(getActivity(), image, cc);
        qrTask.execute(cc);
        Toast.makeText(getActivity(), "s" + cc, Toast.LENGTH_LONG).show();
    }

    static class QRTask extends AsyncTask<String, Void, Bitmap> {
        private WeakReference<Context> mcontext;
        private WeakReference<ImageView> mimage;

        public QRTask(Context context, ImageView imageView, String name) {
            mcontext = new WeakReference<>(context);
            mimage = new WeakReference<>(imageView);
        }

        @Override
        protected Bitmap doInBackground(String... params) {

            String str = params[0];
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            int size = 300;
            return QRCodeEncoder.syncEncodeQRCode(str, size);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {

            if (bitmap != null) {
                mimage.get().setImageBitmap(bitmap);
            } else {
                Toast.makeText(mcontext.get(), "生成失败", Toast.LENGTH_LONG).show();
            }

        }
    }
}

