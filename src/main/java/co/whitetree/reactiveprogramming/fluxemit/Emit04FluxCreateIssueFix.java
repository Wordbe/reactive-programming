package co.whitetree.reactiveprogramming.fluxemit;

import reactor.core.publisher.Flux;

import static co.whitetree.reactiveprogramming.util.Util.faker;
import static co.whitetree.reactiveprogramming.util.Util.subscriber;

public class Emit04FluxCreateIssueFix {
    public static void main(String[] args) {

        // only one instance of fluxsink
        Flux.create(fluxSink -> {
            int count = 0;

            String country;
            do {
                country = faker().country().name();
                System.out.println("emitting : " + country);
                fluxSink.next(country);

                count++;
                if (fluxSink.isCancelled() && count < 10) break; // 'Flux.create()' keeps making items regardless of cancel(), so this logic needed.

            } while (!country.equalsIgnoreCase("canada"));
            fluxSink.complete();
        })
//                .take(3) // take n items, then cancel
                .subscribe(subscriber());
    }
}
