package co.whitetree.reactiveprogramming.operators;

import co.whitetree.reactiveprogramming.util.Util;
import reactor.core.publisher.Flux;
import reactor.util.concurrent.Queues; // <- go to Queues to find '32'

import java.time.Duration;

public class Op05Delay {
    public static void main(String[] args) {

        System.setProperty("reactor.bufferSize.x", "9"); // 조정하면 9개씩 onNext() 가 호출된다.

        Flux.range(1, 100) // 32 produced (default reactor.bufferSize.x)
                .log()
                .delayElements(Duration.ofSeconds(1))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
        // 32
        // 23초후에
        // 56
        // 47초후에
        // 80
        // 60초에 끝
    }
}
