package com.module.base.rx;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * On 2020/12/7
 */
public class RxDemo
{
    Subscriber<String> subscriber = new Subscriber<String>()
    {
        @Override
        public void onSubscribe(Subscription s) {

        }

        @Override
        public void onNext(String s) {

        }

        @Override
        public void onError(Throwable t) {

        }

        @Override
        public void onComplete() {

        }
    };

    Observer<String> observer = new Observer<String>()
    {
        @Override
        public void onSubscribe(@NonNull Disposable d) {

        }

        @Override
        public void onNext(@NonNull String s) {

        }

        @Override
        public void onError(@NonNull Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    };

    private void executeDemo() {
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>()
        {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("张三");
                emitter.onNext("Tom");
                emitter.onComplete();
            }
        });

        Observable<String> observable1 = Observable.just("李四", "Jimmy");

        String[] words = {"王五", "Potter"};
        Observable<String> observable2 = Observable.fromArray(words);

        observable.subscribe(observer);
    }
}
