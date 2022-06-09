package co.whitetree.reactiveprogramming.flux;

import reactor.core.publisher.Flux;

public class Flux02MultipleSubscribers {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.just(1, 2, 3, 4);
        // 한 flux publisher 에 여러 개의 subscriber 가 등록될 수 있다.
        flux.subscribe(i -> System.out.println("[subscriber1]: " + i));
        flux.subscribe(i -> System.out.println("[subscriber2]: " + i));

        Flux<Integer> evenFlux = flux.filter(i -> i % 2 == 0);
        evenFlux.subscribe(i -> System.out.println("[subscriber3]: " + i));
    }
}
