package com.example.zhoucen;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    //https://www.wanandroid.com/project/list/1/json?cid=294
    String url="https://www.wanandroid.com/";
    @GET("project/list/{pass}/json?cid=294")
    Observable<Bean> base(@Path("pass") int pass);
}
