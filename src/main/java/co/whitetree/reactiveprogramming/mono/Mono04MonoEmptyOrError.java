package co.whitetree.reactiveprogramming.mono;

import reactor.core.publisher.Mono;

import static co.whitetree.reactiveprogramming.util.Util.*;

public class Mono04MonoEmptyOrError {

    public static void main(String[] args) {

        userRepository(1L).subscribe(onNext(), onError(), onComplete());
        userRepository(2L).subscribe(onNext(), onError(), onComplete());
        userRepository(3L).subscribe(onNext(), onError(), onComplete());
    }

    private static Mono<String> userRepository(Long userId) {
        if (userId == 1L) return Mono.just(faker().name().firstName());
        if (userId == 2L) return Mono.empty();
        return Mono.error(new RuntimeException("Not in the allowed range"));
    }
}
