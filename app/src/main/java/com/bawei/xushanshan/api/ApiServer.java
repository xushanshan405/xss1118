package com.bawei.xushanshan.api;

import com.bawei.xushanshan.bean.SouBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * FileName: ApiServer
 * Author: 徐姗姗
 * Date: 2019/11/18 9:58
 */
public interface ApiServer {
    @GET("information/v1/findInformationByTitle")

    Observable<SouBean> sou(@Query("title") String title, @Query("page") String page, @Query("count") String count);

    @GET("user/verify/v1/getUserInfoByUserId")
    Observable<SouBean> cha(@Header("userId") String userId, @Header("sessionId") String sessionId);

    @POST("user/verify/v1/modifyHeadPic")

    Observable<SouBean> chuan(@Header("userId")String userId,@Header("sessionId")String sessionId,@Query("image")String image);

}
