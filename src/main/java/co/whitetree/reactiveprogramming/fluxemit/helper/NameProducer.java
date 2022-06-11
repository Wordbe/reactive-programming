package co.whitetree.reactiveprogramming.fluxemit.helper;

import co.whitetree.reactiveprogramming.util.Util;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class NameProducer implements Consumer<FluxSink<String>> {

    private FluxSink<String> fluxSink;

    @Override
    public void accept(FluxSink<String> stringFluxSink) {
        this.fluxSink = stringFluxSink;
    }

    public void produce() {
        String name = Util.faker().name().fullName();
        String thread = Thread.currentThread().getName();
        fluxSink.next("(" + thread + "): " + name);
    }
}
