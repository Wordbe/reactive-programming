package co.whitetree.reactiveprogramming.fluxemit;

import co.whitetree.reactiveprogramming.util.Util;
import reactor.core.publisher.Flux;

public class Emit07FluxGenerateCounter {
    public static void main(String[] args) {

        Flux.generate(
                () -> 1,
                (counter, sink) -> {
                    String country = Util.faker().country().name();
                    sink.next(country);
                    if (counter >= 10 || country.equalsIgnoreCase("canada"))
                        sink.complete();
                    return counter + 1;
                }
        ).subscribe(Util.subscriber());
    }
}
