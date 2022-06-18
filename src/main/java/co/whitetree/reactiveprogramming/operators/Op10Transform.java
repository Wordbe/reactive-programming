package co.whitetree.reactiveprogramming.operators;

import co.whitetree.reactiveprogramming.operators.helper.Person;
import co.whitetree.reactiveprogramming.util.Util;
import reactor.core.publisher.Flux;

public class Op10Transform {
    public static void main(String[] args) {
        person().subscribe(Util.subscriber());
    }

    public static Flux<Person> person() {
        return Flux.range(1, 10)
                .map(i -> new Person());
    }

    public static
}
