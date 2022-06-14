package co.whitetree.reactiveprogramming.operators;

import reactor.core.publisher.Flux;

import static co.whitetree.reactiveprogramming.util.Util.subscriber;

public class Op03DoCallbacks {

    /**
     * Do Hooks / Callbacks
     */
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    System.out.println("inside create");
                    for (int i = 0; i < 5; i++) {
                        fluxSink.next(i);
                    }
                    fluxSink.complete();
//                    fluxSink.error(new RuntimeException("oops"));
                    System.out.println("--completed");
                })
                .doOnComplete(() -> System.out.println("doOnComplete"))
                .doFirst(() -> System.out.println("doFirst 1"))
                .doOnNext(o -> System.out.println("doOnNext : " + o))
                .doOnSubscribe(s -> System.out.println("doOnSubscribe 1 " + s))
                .doOnRequest(value -> System.out.println("doOnRequest : " + value))
                .doFirst(() -> System.out.println("doFirst 2"))
                .doOnError(throwable -> System.out.println("doOnError : " + throwable.getMessage()))
                .doOnTerminate(() -> System.out.println("doOnTerminate"))
                .doOnCancel(() -> System.out.println("doOnCancel"))
                .doOnSubscribe(s -> System.out.println("doOnSubscribe 2 " + s))
                .doFinally(signalType -> System.out.println("doFinally 1 : " + signalType))
                .doFirst(() -> System.out.println("doFirst 3"))
                .doOnDiscard(Object.class, o -> System.out.println("doOnDiscard : " + o))
                .take(2)
                .doFinally(signalType -> System.out.println("doFinally 2 : " + signalType))
                .subscribe(subscriber());

        // doFirst 는 subscriber -> publisher 방향
        // doOnSubscribe 는 publisher -> subscriber 방향
        // take 는 cancel 을 호출. subscriber 아 complete 된다. 그 아래있는 doFinally 는 그 이후 실행된다.

    }
}
