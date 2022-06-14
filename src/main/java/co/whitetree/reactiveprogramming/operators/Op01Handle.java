package co.whitetree.reactiveprogramming.operators;

import reactor.core.publisher.Flux;

import static co.whitetree.reactiveprogramming.util.Util.subscriber;

public class Op01Handle {
    public static void main(String[] args) {

        // handle = map + filter
        Flux.range(1, 10)
                .handle(((integer, synchronousSink) -> {
//                    if (integer % 2 == 0)
//                        synchronousSink.next(integer);
//                    else
//                        synchronousSink.next(integer + "a");
                    if (integer == 7)
                        synchronousSink.complete();
                    else
                        synchronousSink.next(integer);
                }))
                .subscribe(subscriber());
    }
}
