package m;

import com.example.tk5.AppService;
import com.example.tk5.Callback;

import bean.TaBean;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import p.Loginp;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Loginm {
    public void getData(final Callback callback) {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(AppService.urlTab)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        AppService appService = build.create(AppService.class);
        Observable<TaBean> data = appService.data();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TaBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TaBean taBean) {
                       callback.Send(taBean.getData());
                    }

                    @Override
                    public void onError(Throwable e) {
                     callback.File(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
