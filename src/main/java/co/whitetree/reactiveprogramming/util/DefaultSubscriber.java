package co.whitetree.reactiveprogramming.util;

import lombok.NoArgsConstructor;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@NoArgsConstructor
public class DefaultSubscriber implements Subscriber<Object> {

    private String name = "";

    public DefaultSubscriber(String name) {
        this.name = name + " - ";
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println(name + "[onSubscribe]");
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Object o) {
        System.out.println(name + "[onNext]: " + o);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println(name + "[onError]: " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println(name + "[onComplete]");
    }
}
