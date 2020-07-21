package m;

import com.example.zhoucen.ApiService;
import com.example.zhoucen.Bean;
import com.example.zhoucen.Callback;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginM {
    public void getdata(final Callback callback) {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = build.create(ApiService.class);
        Observable<Bean> base = apiService.base(1);
        base.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                      callback.Send(bean.getData().getDatas());
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
