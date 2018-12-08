package com.bw.ymy.week2_1.model;

import com.bw.ymy.week2_1.callback.Mycallback;

public interface IModel {

    void  getRequest(String urlstr, String params, Class clazz, Mycallback callback);
}
