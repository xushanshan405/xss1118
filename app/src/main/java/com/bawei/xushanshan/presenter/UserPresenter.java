package com.bawei.xushanshan.presenter;

import com.bawei.xushanshan.bean.SouBean;
import com.bawei.xushanshan.contract.UserContract;
import com.bawei.xushanshan.model.UserModel;

import java.lang.ref.WeakReference;

/**
 * FileName: UserPresenter
 * Author: 徐姗姗
 * Date: 2019/11/18 10:17
 */
public class UserPresenter implements UserContract.IPersenter {

    private UserModel userModel;
    private WeakReference<UserContract.IView> iViewWeakReference;

    @Override
    public void attachView(UserContract.IView iView) {
        userModel = new UserModel();
        iViewWeakReference = new WeakReference<>(iView);
    }

    public UserContract.IView getView() {
        return iViewWeakReference.get();
    }
    @Override
    public void detachView() {
        if (iViewWeakReference != null) {
            iViewWeakReference.clear();
            iViewWeakReference = null;
        }
    }

    @Override
    public void getSouPresenter(String title, String page, String count) {
        userModel.getUserSou(title, page, count, new UserContract.IModel.ISouCallBack() {
            @Override
            public void onUserSuccess(SouBean souBean) {
                getView().onUserSuccess(souBean);
            }

            @Override
            public void onUserRailure(String railure) {
                getView().onUserRailure(railure);
            }
        });
    }
}
