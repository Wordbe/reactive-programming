package co.whitetree.reactiveprogramming.operators;

import co.whitetree.reactiveprogramming.operators.helper.Person;
import co.whitetree.reactiveprogramming.util.Util;
import reactor.core.publisher.Flux;

import java.util.Objects;
import java.util.function.Function;

public class Op11SwitchOnFirst {
    public static void main(String[] args) {
        person()
                .switchOnFirst((signal, personFlux) -> {
                    System.out.println("switch on first");
                    return signal.isOnNext() && Objects.requireNonNull(signal.get()).getAge() > 10 ? personFlux : applyFilterMap().apply(personFlux);
                })
                .subscribe(Util.subscriber());
    }

    public static Flux<Person> person() {
        return Flux.range(1, 10)
                .map(i -> new Person());
    }

    private static Function<Flux<Person>, Flux<Person>> applyFilterMap() {
        return flux -> flux.filter(person -> person.getAge() > 10)
                .doOnNext(person -> person.setName(person.getName().toUpperCase()))
                .doOnDiscard(Person.class, person -> System.out.println("Not allowing: " + person));
    }
}
