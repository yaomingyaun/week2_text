package com.bw.ymy.week2_1.Activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.bw.ymy.week2_1.Fragment.one;
import com.bw.ymy.week2_1.Fragment.two;
import com.bw.ymy.week2_1.R;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends FragmentActivity {

    private RadioGroup radio1;
    private ViewPager viewPager;
    private List<Fragment> list;

    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        radio1 = findViewById(R.id.radio1);
        viewPager = findViewById(R.id.viewpage1);


        Intent intent = getIntent();
        name = intent.getStringExtra("name");

        //添加
        list = new ArrayList<Fragment>();
        list.add(new one());
        list.add(new two());

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        radio1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.but1:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.but2:
                        viewPager.setCurrentItem(1);
                        break;
                }
            }
        });
    }

    public String cc()
    {
        return  name;
    }
}
