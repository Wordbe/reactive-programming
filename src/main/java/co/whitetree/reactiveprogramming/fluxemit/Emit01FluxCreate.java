package co.whitetree.reactiveprogramming.fluxemit;

import reactor.core.publisher.Flux;

import static co.whitetree.reactiveprogramming.util.Util.faker;
import static co.whitetree.reactiveprogramming.util.Util.subscriber;

public class Emit01FluxCreate {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            String country;
            do {
                country = faker().country().name();
                fluxSink.next(country);
            } while (!country.toLowerCase().equals("canada"));

//            for (int i=0; i<10; i++) {
//                fluxSink.next(faker().country().name());
//            }
            fluxSink.complete();
        })
        .subscribe(subscriber());
    }
}
