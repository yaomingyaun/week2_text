package com.bw.ymy.week2_1.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.ymy.week2_1.Bean.DengBean;
import com.bw.ymy.week2_1.Bean.SingBean;
import com.bw.ymy.week2_1.R;
import com.bw.ymy.week2_1.presenter.IPresenterImpl;
import com.bw.ymy.week2_1.view.IView;

public class SingActivity extends AppCompatActivity implements View.OnClickListener,IView
{

    private EditText zcname,zcpass;
    private Button zhuce;
    IPresenterImpl iPresenter;
    private String name;
    private String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing);

        //获取资源id
        zcname=findViewById(R.id.zcname);
        zcpass=findViewById(R.id.zcpass);
        zhuce=findViewById(R.id.zhuce);
        iPresenter=new IPresenterImpl(this);
        zhuce.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case  R.id.zhuce:
                name=zcname.getText().toString();
                pass=zcpass.getText().toString();
                iPresenter.getRequest("http://120.27.23.105/user/reg?mobile="+name+"&password="+pass,null,SingBean.class);
                break;
        }

    }

    @Override
    public void getRequest(Object data) {

        SingBean singBean= (SingBean) data;
        if(singBean.getCode().equals("0"))
        {
            Toast.makeText(SingActivity.this,"注册成功",Toast.LENGTH_LONG).show();
            Intent intent=new Intent(SingActivity.this,MainActivity.class);
            startActivity(intent);
        }else
        {
            Toast.makeText(SingActivity.this,"注册失败",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        iPresenter.detach();
    }
}
