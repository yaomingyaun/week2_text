package com.bw.ymy.week2_1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.ymy.week2_1.Bean.BannerBean;
import com.bw.ymy.week2_1.Bean.UserBean;
import com.bw.ymy.week2_1.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MyBase extends BaseAdapter {
    private List<BannerBean.NewslistBean> mdata;
    private Context context;

    public MyBase( Context context) {
        this.mdata = new ArrayList<>();
        this.context = context;
    }
    public  void setlist(List<BannerBean.NewslistBean> mdata )
    {
            this .mdata=mdata;
            notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mdata.size();
    }

    @Override
    public BannerBean.NewslistBean getItem(int position) {
        return mdata.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView==null)
        {
            convertView=LayoutInflater.from(context).inflate(R.layout.item1,parent,false);
            holder=new ViewHolder();
            holder.title=convertView.findViewById(R.id.title);
            holder.icon1=convertView.findViewById(R.id.icon1);
            holder.icon2=convertView.findViewById(R.id.icon2);
            holder.icon3=convertView.findViewById(R.id.icon3);
            convertView.setTag(holder);
        }
        else
        {
          holder= (ViewHolder) convertView.getTag();
        }
        holder.title.setText(mdata.get(position).getTitle());
        ImageLoader.getInstance().displayImage(getItem(position).getPicUrl(),holder.icon1);
        //ImageLoader.getInstance().displayImage(getItem(position).getThumbnail_pic_s02(),holder.icon2);
      //  ImageLoader.getInstance().displayImage(getItem(position).getThumbnail_pic_s03(),holder.icon3);
        return convertView;
    }
    class  ViewHolder{
        TextView title;
        ImageView icon1,icon2,icon3;
    }
}
