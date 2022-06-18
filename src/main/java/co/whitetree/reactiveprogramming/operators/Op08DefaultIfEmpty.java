package co.whitetree.reactiveprogramming.operators;

import co.whitetree.reactiveprogramming.util.Util;
import reactor.core.publisher.Flux;

public class Op08DefaultIfEmpty {
    public static void main(String[] args) {
        orderNumbers().filter(i -> i > 10)
                .defaultIfEmpty(-100)
                .subscribe(Util.subscriber());
    }

    private static Flux<Integer> orderNumbers() {
        return Flux.range(1, 10); // 1, 2, ..., 10
    }
}
