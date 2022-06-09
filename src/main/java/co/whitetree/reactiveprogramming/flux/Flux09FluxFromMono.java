package co.whitetree.reactiveprogramming.flux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static co.whitetree.reactiveprogramming.util.Util.*;

public class Flux09FluxFromMono {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("a Mono");
        Flux<String> flux = Flux.from(mono);
        flux.subscribe(onNext());

        Flux.range(1, 10)
                .filter(i -> i > 3)
                // next : Flex to Mono | findFirst 처럼 사용될 수 있다.
                .next()
                .subscribe(onNext(), onError(), onComplete());
    }
}
