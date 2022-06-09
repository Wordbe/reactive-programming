package co.whitetree.reactiveprogramming.flux;

import co.whitetree.reactiveprogramming.util.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

import static co.whitetree.reactiveprogramming.util.Util.*;

public class Flux04FluxFromStream {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3);
        Stream<Integer> stream = list.stream();

        // stream 은 재활용할 수 없다.
//        stream.forEach(System.out::println); // closed
//        stream.forEach(System.out::println); // Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed

//        Flux<Integer> flux = Flux.fromStream(stream); // 같은 객체를 참조하므로 2번째에서는 에러가 난다.
        Flux<Integer> flux = Flux.fromStream(() -> list.stream()); // 이렇게하면 subscribe 할 때마다 새로운 스트림을 생성한다.
        flux.subscribe(onNext(), onError(), onComplete());
        flux.subscribe(onNext(), onError(), onComplete());
    }
}
