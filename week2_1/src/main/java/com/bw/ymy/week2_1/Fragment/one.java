package com.bw.ymy.week2_1.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.bw.ymy.week2_1.Adapter.MyBase;
import com.bw.ymy.week2_1.Bean.BannerBean;
import com.bw.ymy.week2_1.Bean.UserBean;
import com.bw.ymy.week2_1.R;
import com.bw.ymy.week2_1.presenter.IPresenterImpl;
import com.bw.ymy.week2_1.view.IView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoaderInterface;

import java.util.ArrayList;
import java.util.List;

import me.maxwin.view.XListView;

public class one extends Fragment implements IView {

    //轮播图
    private Banner banner;
    IPresenterImpl iPresenter;
    //展示数据
    private ListView xListView;
    private MyBase adapter;
    private  int page=1;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.one,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //获取资源id
        banner=view.findViewById(R.id.banner);
        xListView=view.findViewById(R.id.xlistview);
        iPresenter=new IPresenterImpl(one.this);


        adapter=new MyBase(getActivity());
        xListView.setAdapter(adapter);




        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        banner.setImageLoader(new ImageLoaderInterface<ImageView>() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                BannerBean.NewslistBean bean= (BannerBean.NewslistBean) path;
                ImageLoader.getInstance().displayImage(bean.getPicUrl(),imageView);

            }

            @Override
            public ImageView createImageView(Context context) {
                ImageView imageView=new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                return imageView;
            }
        });
        inlodata();
    }

    private void inlodata() {

        iPresenter.getRequest("https://api.tianapi.com/wxnew/?key=c4aa776e0a51d57d6750511e2baa46b6&num=6&page=1",null,BannerBean.class);


    }

    @Override
    public void getRequest(Object data) {

        BannerBean bannerBean= (BannerBean) data;
        banner.setImages(((BannerBean) data).getNewslist());
        banner.setBannerTitles(getTiles(bannerBean));
        banner.start();



        adapter.setlist(bannerBean.getNewslist());







    }
    private List<String> getTiles(BannerBean bannerBean)
    {
        List<String> list=new ArrayList<>();
        for (BannerBean.NewslistBean banner:bannerBean.getNewslist())
        {
            list.add(banner.getTitle());
        }
        return  list;
    }
}
