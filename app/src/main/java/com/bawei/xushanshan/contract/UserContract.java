package com.bawei.xushanshan.contract;

import com.bawei.xushanshan.bean.SouBean;

/**
 * FileName: UserContract
 * Author: 徐姗姗
 * Date: 2019/11/18 10:11
 */
public interface UserContract {
    interface IView{
        void onUserSuccess(SouBean success);

        void onUserRailure(String e);
    }
    interface IModel{
        void getUserSou(String title, String page, String count, ISouCallBack iSouCallBack);
        interface ISouCallBack{
            void onUserSuccess(SouBean souBean);

            void onUserRailure(String railure);
        }
    }
    interface IPersenter{
        void attachView(UserContract.IView iView);

        void detachView();

        void getSouPresenter(String title, String page, String count);
    }
}
