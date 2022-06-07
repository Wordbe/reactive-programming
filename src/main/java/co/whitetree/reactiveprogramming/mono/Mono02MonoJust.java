package co.whitetree.reactiveprogramming.mono;

import reactor.core.publisher.Mono;

public class Mono02MonoJust {

    public static void main(String[] args) {

        // publisher
        Mono<Integer> mono = Mono.just(1);

        // do not work before subscribe
        System.out.println("mono = " + mono);

        mono.subscribe(i -> System.out.println("Received: " + i));
    }
}
