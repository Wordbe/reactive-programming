package co.whitetree.reactiveprogramming.mono;

import java.util.stream.Stream;

public class Mono01Stream {

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1)
                .map(it -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return it * 2;
                });

//        System.out.println("stream = " + stream);

        // Stream is Lazy, terminal operator needed.
        stream.forEach(System.out::println);
    }
}
