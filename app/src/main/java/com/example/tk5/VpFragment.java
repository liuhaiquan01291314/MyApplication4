package com.example.tk5;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

import bean.VpBean;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class VpFragment extends Fragment {


    private View view;
    private RecyclerView mRecy;
    private MyRecyAdapter adapter;
    private ArrayList<VpBean.DataBean.DatasBean> vpBeans;
    private SmartRefreshLayout mSmart;
    int pas=1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_vp, container, false);
        initView(inflate);
        initdata();
        return inflate;
    }

    private void initdata() {
        String cid = getArguments().getString("cid");
        Retrofit build = new Retrofit.Builder()
                .baseUrl(AppService.urlVP)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        AppService appService = build.create(AppService.class);
        Observable<VpBean> vp = appService.vp(pas, cid);
        vp.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VpBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(VpBean vpBean) {
                        vpBeans.addAll(vpBean.getData().getDatas());
                        adapter.notifyDataSetChanged();
                        mSmart.finishRefresh();
                        mSmart.finishLoadMore();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView(View inflate) {
        mRecy = (RecyclerView) inflate.findViewById(R.id.Recy);
        mSmart = inflate.findViewById(R.id.smart);
        mSmart.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {  //下拉加载
                    pas++;
                    initdata();
            }
        });
        mSmart.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) { //上拉刷新
                pas = 1;
                vpBeans.clear();
                initdata();
            }
        });
        mRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecy.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));
        vpBeans = new ArrayList<>(); //list集合
        adapter = new MyRecyAdapter(vpBeans, getActivity()); //创建适配器
        mRecy.setAdapter(adapter); //绑定适配器

    }
}
