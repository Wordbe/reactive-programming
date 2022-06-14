package co.whitetree.reactiveprogramming.operators;

import co.whitetree.reactiveprogramming.util.Util;
import reactor.core.publisher.Flux;

import java.util.Objects;

public class Op02Handle {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> synchronousSink.next(Util.faker().country().name()))
                .map(Objects::toString)
                .handle((s, synchronousSink) -> {
                    synchronousSink.next(s);
                    if (s.equalsIgnoreCase("canada"))
                        synchronousSink.complete();
                })
                .subscribe(Util.subscriber());
    }
}
