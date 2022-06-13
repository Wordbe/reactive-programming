package co.whitetree.reactiveprogramming.fluxemit;

import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

import static co.whitetree.reactiveprogramming.util.Util.faker;
import static co.whitetree.reactiveprogramming.util.Util.subscriber;

public class Emit06FluxGenerate2 {
    public static void main(String[] args) {

        // canada
        // max = 10
        // subscriber cancels - exit

        // only one instance of fluxsink
        Flux.generate(synchronousSink -> {
            String country = faker().country().name();
            System.out.println("emitting " + country);
            synchronousSink.next(country);
            if (country.equalsIgnoreCase("canada"))
                synchronousSink.complete();
        })
        .subscribe(subscriber());
    }
}
