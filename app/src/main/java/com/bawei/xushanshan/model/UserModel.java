package com.bawei.xushanshan.model;

import com.bawei.xushanshan.bean.SouBean;
import com.bawei.xushanshan.contract.UserContract;
import com.bawei.xushanshan.utils.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * FileName: UserModel
 * Author: 徐姗姗
 * Date: 2019/11/18 10:16
 */
public class UserModel implements UserContract.IModel {

    private Observable<SouBean> observable;
    private Observer<SouBean> observer;

    @Override
    public void getUserSou(String title, String page, String count, final ISouCallBack iSouCallBack) {
        observable = RetrofitUtil.getApiServer().sou(title, page, count);
        observer = new Observer<SouBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(SouBean souBean) {
                iSouCallBack.onUserSuccess(souBean);
            }

            @Override
            public void onError(Throwable e) {
                iSouCallBack.onUserRailure(e.toString());
            }

            @Override
            public void onComplete() {

            }
        };
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
