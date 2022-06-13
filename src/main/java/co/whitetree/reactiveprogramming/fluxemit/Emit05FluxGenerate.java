package co.whitetree.reactiveprogramming.fluxemit;

import co.whitetree.reactiveprogramming.util.Util;
import reactor.core.publisher.Flux;

public class Emit05FluxGenerate {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
            System.out.println("emitting");
            synchronousSink.next(Util.faker().country().name()); // using only one `next`, generate infinitely
//            synchronousSink.next(Util.faker().country().name()); // compile error
//            synchronousSink.complete(); // onComplete and stop
//            synchronousSink.error(new RuntimeException("oops")); // onError and stop
        })
                .take(2)
                .subscribe(Util.subscriber());
    }
}
