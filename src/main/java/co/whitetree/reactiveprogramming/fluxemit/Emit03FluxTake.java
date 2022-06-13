package co.whitetree.reactiveprogramming.fluxemit;

import co.whitetree.reactiveprogramming.util.Util;
import reactor.core.publisher.Flux;

public class Emit03FluxTake {
    public static void main(String[] args) {

        Flux.range(1, 10)
                .log()
                .take(3) // take n items, then cancel
                .log()
                .subscribe(Util.subscriber());
    }
}
