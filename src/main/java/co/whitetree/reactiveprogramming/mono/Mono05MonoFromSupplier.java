package co.whitetree.reactiveprogramming.mono;

import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

import static co.whitetree.reactiveprogramming.util.Util.faker;
import static co.whitetree.reactiveprogramming.util.Util.onNext;

public class Mono05MonoFromSupplier {

    public static void main(String[] args) {

        // use just only when you have data already.
//        Mono<String> mono = Mono.just(getName());

        // 함수를 invoke 하지 않고 싶다면 fromSupplier 사용
        Supplier<String> stringSupplier = () -> getName();
        Mono<String> mono = Mono.fromSupplier(stringSupplier);
        mono.subscribe(onNext());

        // 다른 인터페이스지만, fromSupplier 처럼 똑같이 적용가능하다.
        Callable<String> stringCallable = () -> getName();
        Mono.fromCallable(stringCallable)
                .subscribe(onNext());
    }

    private static String getName() {
        System.out.println("Generating name...");
        return faker().name().firstName();
    }
}
