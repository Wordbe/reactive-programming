package co.whitetree.reactiveprogramming.fluxemit;

import co.whitetree.reactiveprogramming.fluxemit.helper.NameProducer;
import reactor.core.publisher.Flux;

import static co.whitetree.reactiveprogramming.util.Util.sleepSeconds;
import static co.whitetree.reactiveprogramming.util.Util.subscriber;

public class Emit02FluxCreateRefactoring {

    public static void main(String[] args) {
        NameProducer nameProducer = new NameProducer();
        Flux.create(nameProducer)
                .subscribe(subscriber());

        Runnable runnable = nameProducer::produce;
        for (int i=0; i<10; i++) {
            new Thread(runnable).start();
        }

        sleepSeconds(2);
    }
}
