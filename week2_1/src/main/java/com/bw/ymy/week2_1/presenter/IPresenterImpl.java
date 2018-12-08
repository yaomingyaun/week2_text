package com.bw.ymy.week2_1.presenter;

import com.bw.ymy.week2_1.callback.Mycallback;
import com.bw.ymy.week2_1.model.IModelIml;
import com.bw.ymy.week2_1.view.IView;

public class IPresenterImpl implements  IPresenter {


    //把M  V  实列化
    private IView mIview;
    private IModelIml mImodel;

    public IPresenterImpl(IView mIview) {
        this.mIview = mIview;
        mImodel=new IModelIml();
    }

    @Override
    public void getRequest(String urlstr, String params, Class clazz) {


        mImodel.getRequest(urlstr, params, clazz, new Mycallback() {
            @Override
            public void onsuccess(Object data) {
                mIview.getRequest(data);
            }
        });

    }
    //解绑
    public void detach(){
        if(mIview!=null) {
            mIview = null;
        }
        if(mImodel!=null) {
            mImodel = null;
        }
    }

}
