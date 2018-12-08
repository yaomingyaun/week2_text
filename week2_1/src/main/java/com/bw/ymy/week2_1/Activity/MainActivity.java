package com.bw.ymy.week2_1.Activity;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.bw.ymy.week2_1.Bean.DengBean;
import com.bw.ymy.week2_1.R;
import com.bw.ymy.week2_1.presenter.IPresenterImpl;
import com.bw.ymy.week2_1.view.IView;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,IView
{

    private EditText etname,etpass;
    private CheckBox checkBox1,checkBox2;
    private Button login,sing;
    private ImageView qq_login;
    IPresenterImpl iPresenter;

    private String name;
    private  String pass;

        //s1
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取资源Id
        etname=findViewById(R.id.etname);
        etpass=findViewById(R.id.etpass);
        checkBox1=findViewById(R.id.check_jz);
        checkBox2=findViewById(R.id.check_zd);
        login=findViewById(R.id.login);
        sing=findViewById(R.id.sing);
        qq_login=findViewById(R.id.qq_login);

        //实列化p
        iPresenter=new IPresenterImpl(this);
        //登录
        login.setOnClickListener(this);
        sing.setOnClickListener(this);
        qq_login.setOnClickListener(this);


           // checkPermission();

        //s2
        sharedPreferences=getSharedPreferences("User",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        //s5
        boolean j=sharedPreferences.getBoolean("j",false);
        if(j)
        {
            //将值取出来
            String names=sharedPreferences.getString("name",null);
            String pass=sharedPreferences.getString("pass",null);
            //赋值进去
            etname.setText(names);
            etpass.setText(pass);
            //勾选状态
            checkBox1.setChecked(true);
        }
        //自动登录
        boolean z=sharedPreferences.getBoolean("z",false);
        if(z)
        {
            //跳转到另一个页面
            Intent intent = new Intent(MainActivity.this,LoginActivity.class);
            String admin = sharedPreferences.getString("admin", null);
            intent.putExtra("username",admin);
            startActivity(intent);
        }
        //点击自动登录时 同时记住密码
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    checkBox1.setChecked(true);
                }else
                {
                    checkBox1.setChecked(false);
                }
            }
        });




    }

    /*@Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }*/

    /**
     * 动态添加权限，模拟器Android版本小于6.0的不用写，再有问的打死
     */
   /* private void checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.CALL_PHONE,
                    Manifest.permission.READ_LOGS,
                    Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.SET_DEBUG_APP,
                    Manifest.permission.SYSTEM_ALERT_WINDOW,
                    Manifest.permission.GET_ACCOUNTS,
                    Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this, mPermissionList, 123);
        }
    }
*/


    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            //登录
            case R.id.login:
                    name=etname.getText().toString();
                    pass=etpass.getText().toString();
                    //判断是否
                if(checkBox1.isChecked())
                {
                    //将值存入里面
                    editor.putString("name",name);
                    editor.putString("pass",pass);
                    //上方判断  存入一个勾选状态
                    editor.putBoolean("j",true);
                    //提交
                    editor.commit();
                }else
                {
                    //清空
                    editor.clear();
                    //提交
                    editor.commit();
                }
                //记住密码勾选状态
                if(checkBox2.isChecked())
                {
                    editor.putBoolean("z",true);
                    //提交
                    editor.commit();
                }

                    //非空
                    iPresenter.getRequest("http://120.27.23.105/user/login?mobile="+name+"&password="+pass,null,DengBean.class);
                    break;
                    //注册
            case  R.id.sing:
                Intent intent=new Intent(MainActivity.this,SingActivity.class);
                startActivity(intent);
                break;

                //第三方登录
            case R.id.qq_login:
                UMShareAPI umShareAPI=UMShareAPI.get(MainActivity.this);
                umShareAPI.getPlatformInfo(MainActivity.this, SHARE_MEDIA.QQ, new UMAuthListener() {
                    //跳转到页面
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {
                        //跳转到另一个页面
                        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                        DengBean.DataBean dataBean=new DengBean.DataBean();
                        intent.putExtra("name",dataBean.getUsername());

                        startActivity(intent);

                    }

                    @Override
                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {

                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media, int i) {

                    }
                });
                break;
                default:
                    break;

        }
    }
    @Override
    public void getRequest(Object data) {

        DengBean dengBean= (DengBean) data;
        if(dengBean.getCode().equals("0"))
        {

            Toast.makeText(MainActivity.this,"成功",Toast.LENGTH_LONG).show();
            //跳转到登录成功
            Intent intent=new Intent(MainActivity.this,LoginActivity.class);
            //跳转过去 传值
            intent.putExtra("name",dengBean.getData().getUsername());
            startActivity(intent);
        }else
        {
            Toast.makeText(MainActivity.this,"账号或者密码错误",Toast.LENGTH_LONG).show();
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        iPresenter.detach();
    }
}
