package com.bawei.xushanshan.utils;

import com.bawei.xushanshan.api.ApiServer;

import java.io.IOException;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * FileName: RetrofitUtil
 * Author: 徐姗姗
 * Date: 2019/11/18 9:58
 */
public class RetrofitUtil {
    private static ApiServer apiServer;
    private Retrofit retrofit;
    private OkHttpClient okHttpClient;
    private HttpLoggingInterceptor httpLoggingInterceptor;

    public RetrofitUtil() {
    }
    //单例
    public static ApiServer getApiServer() {
        if (apiServer == null) {
            synchronized (RetrofitUtil.class) {
                if (apiServer == null) {
                    apiServer = new RetrofitUtil().getRetrofit();
                }
            }
        }
        return apiServer;
    }

    private ApiServer getRetrofit() {
        ApiServer apiServer = initRetrofit(initOk()).create(ApiServer.class);
        return apiServer;
    }

 /*try {
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(null);
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        X509Certificate certificate = (X509Certificate) certificateFactory.generateCertificate(App.sContext.getResources().openRawResource(R.raw.server));
        SSLContext sc = SSLContext.getInstance("TLS");
        TrustManager tm = new MyTrustManager(certificate);
        sc.init(null, new TrustManager[]{
                tm
        }, null);*/
    private OkHttpClient initOk() {

        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {

                    private Request request;
                    private Response response;

                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        request = chain.request();
                        response = chain.proceed(request);
                        return response;
                    }
                }).retryOnConnectionFailure(true)
                .build();
        return okHttpClient;
    }

    private Retrofit initRetrofit(OkHttpClient client) {
        //拦截器
        httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("https://172.17.8.100/techApi/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
