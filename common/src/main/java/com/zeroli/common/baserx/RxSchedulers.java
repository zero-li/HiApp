package com.zeroli.common.baserx;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * des:RxJava调度管理
 * <p>
 * Created by zhh_li on 2016/10/25.
 */

public class RxSchedulers {
    public static <T>Observable.Transformer<T,T> io_main(){
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
