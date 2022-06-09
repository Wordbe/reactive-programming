package co.whitetree.reactiveprogramming.flux;

import reactor.core.publisher.Flux;

import static co.whitetree.reactiveprogramming.util.Util.*;

public class Flux01FluxIntro {

    public static void main(String[] args) {

//        Flux<Object> flux = Flux.empty();
        Flux<Object> flux = Flux.just(1, 2, 3, 4, "a", faker().name().fullName());
        flux.subscribe(onNext(), onError(), onComplete());
    }
}
