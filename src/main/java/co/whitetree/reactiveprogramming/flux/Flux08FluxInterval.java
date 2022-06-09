package co.whitetree.reactiveprogramming.flux;

import reactor.core.publisher.Flux;

import java.time.Duration;

import static co.whitetree.reactiveprogramming.util.Util.onNext;
import static co.whitetree.reactiveprogramming.util.Util.sleepSeconds;

public class Flux08FluxInterval {
    public static void main(String[] args) {

        // product items periodically
        Flux.interval(Duration.ofSeconds(1))
                .subscribe(onNext());

        // 메인 쓰레드가 실행되는 동안, 위의 publisher 가 async 하게 subscribe 를 실행
        sleepSeconds(5);
    }
}
