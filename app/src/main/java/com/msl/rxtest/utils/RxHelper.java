package com.msl.rxtest.utils;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

public class RxHelper {

    private static final String TEXT = "text";

    public static Observable<String> getObservable() {

        //
//        Observable<String> observable =
//                Observable.just(TEXT)
//                .subscribeOn(Schedulers.computation())
//                        .map(String::toUpperCase)
//                .observeOn(AndroidSchedulers.mainThread());

//        return Observable.just(TEXT)
//                .subscribeOn(Schedulers.computation())
//                .map(String::toUpperCase)
//                .observeOn(AndroidSchedulers.mainThread());

        return Observable.create((ObservableOnSubscribe<String>) emitter -> {
            emitter.onNext(TEXT);
            emitter.onNext("qweqwe");
            emitter.onComplete();
        })
            .subscribeOn(Schedulers.computation())
            .map(String::toUpperCase)
            .observeOn(AndroidSchedulers.mainThread());
    }
}
