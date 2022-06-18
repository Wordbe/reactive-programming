package co.whitetree.reactiveprogramming.operators;

import co.whitetree.reactiveprogramming.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Op07Timeout {
    public static void main(String[] args) {
        orderNumbers().timeout(Duration.ofSeconds(2), fallback()) // 2초 안에 응답없으면 fallback 실행
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }

    private static Flux<Integer> orderNumbers() {
        return Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1));
    }

    private static Flux<Integer> fallback() {
        return Flux.range(100, 10)
                .delayElements(Duration.ofMillis(200));
    }
}
