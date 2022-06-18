package co.whitetree.reactiveprogramming.operators;

import co.whitetree.reactiveprogramming.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Op06OnError {
    public static void main(String[] args) {

        Flux.range(1, 10)
                .log()
                .map(i -> 10 / (5 - i))
//                .onErrorReturn(-1)
//                .onErrorResume(throwable -> fallback())
                .onErrorContinue((throwable, o) -> {})
                .subscribe(Util.subscriber());
    }

    private static Mono<Integer> fallback() {
        return Mono.fromSupplier(() -> Util.faker().random().nextInt(100, 200));
    }
}
