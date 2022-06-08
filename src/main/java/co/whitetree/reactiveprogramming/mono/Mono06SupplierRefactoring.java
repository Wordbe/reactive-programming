package co.whitetree.reactiveprogramming.mono;

import co.whitetree.reactiveprogramming.util.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import static co.whitetree.reactiveprogramming.util.Util.*;

public class Mono06SupplierRefactoring {

    public static void main(String[] args) {
        getName();
//        getName().subscribe(onNext()); // blocking (1)
//        getName().subscribeOn(Schedulers.boundedElastic())
//                .subscribe(onNext()); // (2)
        String name = getName().subscribeOn(Schedulers.boundedElastic())
                .block(); // (3) blocking
        System.out.println("name = " + name);
        getName();

        // main thread 가 blocking 될 동안 (2) 가 실행된다.
        Util.sleepSeconds(4);
    }

    private static Mono<String> getName() {
        System.out.println("entered getName method");

        // lazy 하게 실행시키고 싶은 것은 supplier 안으로
        return Mono.fromSupplier(() -> {
            System.out.println("Generating name...");
            sleepSeconds(3);
            return faker().name().fullName();
        }).map(String::toUpperCase);
    }
}
