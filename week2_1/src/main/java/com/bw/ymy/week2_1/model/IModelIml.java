package com.bw.ymy.week2_1.model;

import android.os.AsyncTask;

import com.bw.ymy.week2_1.Nutils.Nutils;
import com.bw.ymy.week2_1.callback.Mycallback;
import com.google.gson.Gson;

public class IModelIml implements IModel {

    public  <T>  T getRequest(String urlstr, String params, Class clazz)
    {

        //继承工具类
        return (T)new Gson().fromJson(Nutils.getRequest(urlstr),clazz);

    }

    @Override
    public void getRequest (final  String urlstr,final  String params,final  Class clazz, final Mycallback callback) {

        new AsyncTask<String,Void,Object>()
        {
            @Override
            protected Object doInBackground(String... strings) {
                return getRequest(urlstr, params, clazz);
            }

            @Override
            protected void onPostExecute(Object o) {
               callback.onsuccess(o);
            }
        }.execute(urlstr);

    }
}
