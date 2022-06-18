package co.whitetree.reactiveprogramming.operators;

import co.whitetree.reactiveprogramming.util.Util;
import reactor.core.publisher.Flux;

public class Op09SwitchIfEmpty {
    public static void main(String[] args) {
        orderNumbers().filter(i -> i > 10)
                .switchIfEmpty(alternate())
                .subscribe(Util.subscriber());
    }

    // redis cache
    private static Flux<Integer> orderNumbers() {
        return Flux.range(1, 10); // 1, 2, ..., 10
    }

    // real db
    private static Flux<Integer> alternate() {
        return Flux.range(20, 5); // 20, 21, ..., 24
    }
}
