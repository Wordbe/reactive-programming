package co.whitetree.reactiveprogramming.mono;

import reactor.core.publisher.Mono;

import static co.whitetree.reactiveprogramming.util.Util.*;

public class Mono02MonoSubscribe {

    public static void main(String[] args) {
        // publisher
        Mono<Integer> mono = Mono.just("ball")
                .map(String::length)
                .map(l -> l / 0); // exception
//        mono.subscribe();
        mono.subscribe(
                onNext(),
                onError(),
                onComplete());
    }
}
