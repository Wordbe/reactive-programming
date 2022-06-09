package co.whitetree.reactiveprogramming.flux;

import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

import static co.whitetree.reactiveprogramming.util.Util.onNext;

public class Flux03FluxFromArrayOrList {
    public static void main(String[] args) {
        List<String> iterable = Arrays.asList("a", "b", "c");
        Flux.fromIterable(iterable)
                .subscribe(onNext());

        Integer[] array = {2, 5, 7, 8};
        Flux.fromArray(array)
                .subscribe(onNext());
    }
}
