package co.whitetree.reactiveprogramming.mono;

import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

import static co.whitetree.reactiveprogramming.util.Util.*;

public class Mono07MonoFromFuture {

    public static void main(String[] args) {
        // async
        Mono.fromFuture(getName())
                .subscribe(onNext());

        // main thread 가 1초 기다린다. 이시간동안 위에 mono 출력 결과를 볼 수 있다.
        sleepSeconds(1);
    }

    private static CompletableFuture<String> getName() {
        return CompletableFuture.supplyAsync(() -> faker().name().fullName());
    }
}
