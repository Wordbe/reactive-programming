package co.whitetree.reactiveprogramming.flux;

import reactor.core.publisher.Flux;

import static co.whitetree.reactiveprogramming.util.Util.faker;
import static co.whitetree.reactiveprogramming.util.Util.onNext;

public class Flux05FluxRange {
    public static void main(String[] args) {
        Flux.range(1, 10) // increment by 1 (1)
                .log() // log 확인 가능 onSubscribe -> request -> onNext 10 times -> onComplete | (1)을 요청
                .map(i -> faker().name().fullName()) // (2)
                .log() // (2) 를 요청
                .subscribe(onNext());
    }
}
