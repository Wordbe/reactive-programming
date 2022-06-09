package co.whitetree.reactiveprogramming.flux;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

import static co.whitetree.reactiveprogramming.util.Util.sleepSeconds;

public class Flux06CustomSubscription {
    public static void main(String[] args) {

        AtomicReference<Subscription> atomicReference = new AtomicReference<>();

        Flux.range(1, 20)
                .log()
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("[onSubscribe]: " + subscription);
                        atomicReference.set(subscription);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("[onNext]: " + integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("[onError]: " + throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("[onComplete]");
                    }
                });

        sleepSeconds(3);
        atomicReference.get().request(3);
        sleepSeconds(5);
        atomicReference.get().request(3);
        sleepSeconds(5);
        System.out.println("going to cancel...");
        atomicReference.get().cancel();
        sleepSeconds(3);
        atomicReference.get().request(4);
    }
}
