package com.example.tk5;

import bean.TaBean;
import bean.VpBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface AppService {
    String urlTab="https://www.wanandroid.com/";
    @GET("project/tree/json")
    Observable<TaBean> data();
    String urlVP="https://www.wanandroid.com/";
    @GET("project/list/{pass}/json")
    Observable<VpBean> vp(@Path("pass") int pass, @Query("cid") String cid);
}
